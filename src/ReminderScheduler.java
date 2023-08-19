import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ReminderScheduler {
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    public void scheduleReminder(Reminder reminder) {
        long delay = reminder.getTime().getTime() - System.currentTimeMillis();
        ScheduledFuture<?> future = executor.schedule(() -> {
            System.out.println("Reminder: " + reminder.getTask() + " - Time: " + reminder.getTime());
        }, delay, TimeUnit.MILLISECONDS);
    }

    public void cancelReminder(Reminder reminder) {

    }

    public void markReminderAsCompleted(Reminder reminder) {
        reminder.isCompleted();
        System.out.println("Reminder marked as completed: " + reminder.getTask());
    }

    public void shutdown() {
        executor.shutdown();
    }
}
