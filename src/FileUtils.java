import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileUtils {
    private static final Logger logger = Logger.getLogger(FileUtils.class.getName());

    static {

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
    }
    public static void copyWithDuplicateName(File srcFile) throws IOException {
        try {
            String originalFileName = srcFile.getName();
            int dotIndex = originalFileName.lastIndexOf('.');
            String nameWithoutExtension = originalFileName.substring(0, dotIndex);
            String extension = originalFileName.substring(dotIndex);

            int copyNumber = 1;
            File destFile = new File(srcFile.getParent(), nameWithoutExtension + "(" + copyNumber + ")" + extension);
            while (destFile.exists()) {
                copyNumber++;
                destFile = new File(srcFile.getParent(), nameWithoutExtension + "(" + copyNumber + ")" + extension);
            }

            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.COPY_ATTRIBUTES);

            logger.info("File copied with duplicate name: " + destFile.getName());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error copying file with duplicate name");
        }
    }

    public static void copyFile(File srcFile, File destFile) {
        try (InputStream inStream = new FileInputStream(srcFile);
             OutputStream outStream = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }

            logger.info("File copied from " + srcFile.getName() + " to " + destFile.getName());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error copying file", e);
        }
    }

    public static void main(String[] args) throws IOException {
        File sourceFile = new File("source.txt");
        File destinationFile = new File("destination.txt");

        copyWithDuplicateName(sourceFile);

        copyFile(sourceFile, destinationFile);
    }
}

