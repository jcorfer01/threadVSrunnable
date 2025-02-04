package threadVSrunnable;

/**
 * ExampleRunnable is a class that shows how to implement the Runnable interface with a brief example.
 * This class could extend any other class as we are implementing an interface instead of extending the class Thread.
 * <br><br>
 * The thread will be identified by using the method setName() after initializing the variable type Thread,
 * so instead of using a local int id, we would use Thread.currentThread().getName().
 * <br>
 * Inside the run() method, I created a loop that shows 1 number every second (5 numbers shown in total).
 *
 * @author      Jorge Correyero
 * @version     1.0
 */

public class ExampleRunnable implements Runnable {
    // Methods
    /**
     * Overrides the run() method from the interface Runnable.
     */
    @Override
    public void run () {
        for (int i = 0; i < 5; i++) { // Counts 5 numbers (0-4)
            System.out.println("Thread " + Thread.currentThread().getName() + ": " + i);

            try {
                Thread.sleep(1000); // Waits 1 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
