import java.util.logging.Logger;

//todo - simulate the race condition problem here
// and the solution with commenting previous state.
public class RaceConditionProblem {
        public static void main(String[] args) {


            Counter counter = new Counter();

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            });

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(" Counter qiymati " + counter.getCount());


            CounterSync counterSync = new CounterSync();

            Thread thread3 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    counterSync.increment();
                }
            });

            Thread thread4 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    counterSync.increment();
                }
            });

            thread3.start();
            thread4.start();

            try {
                thread3.join();
                thread4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("hisoblagich qiymati " + counterSync.getCount());
        }

    }






