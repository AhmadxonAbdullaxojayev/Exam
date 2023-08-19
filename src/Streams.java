import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//todo - in this class create two methods that can handle file copying
// 1.first method must include src file and from it your method will have to
// create another duplicate file. Then name of duplicate file should be like
// notes.txt => notes(1).txt
// 2.second method must include as an input two parameters , scr file and
// destination file. This method will reads from src file and writes to
// destination file.
// 3.For the class involve logger to log method operation details.
// When your methods throws an exception log error message to the console
// When copy file successfully finishes log info about it.
public class Streams {
    public static void main(String[] args) throws ParseException {
        ReminderScheduler scheduler = new ReminderScheduler();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Reminder Application");
            System.out.println("1. Schedule a reminder");
            System.out.println("2. Mark a reminder as completed");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    System.out.print("Enter time (yyyy-MM-dd HH:mm:ss): ");
                    String timeStr = scanner.nextLine();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date time = dateFormat.parse(timeStr);
                    Reminder reminder = new Reminder(task, time);
                    scheduler.scheduleReminder(reminder);
                    break;
                case 2:
                    System.out.print("Enter task description: ");
                    String taskToMark = scanner.nextLine();

                    break;
                case 3:
                    scheduler.shutdown();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
