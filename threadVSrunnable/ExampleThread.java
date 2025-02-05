package threadVSrunnable;

/**
 * ExampleThread is a class that shows how to extend the class Thread with a basic example.
 * <br><br>
 * Inside this class I created an attribute numThread to serve as the identifier of the thread.
 * Another way to name or identify the Thread would be with the method setName() after initializing
 * the thread, so instead of using this.numThread, we would use Thread.currentThread().getName().
 * <br>
 * Inside the run() method, I created a loop that shows 1 number every second (5 numbers shown in total).
 * On the other hand, I created the setter and getter for the attribute numThread.
 *
 * @author      Jorge Correyero
 * @version     1.0
 */

public class ExampleThread extends Thread{
    // Attributes
    private int numThread;

    // Constructors
    /**
     * Parameterized constructor.
     *
     * @param numThread identifier of the Thread created.
     */
    public ExampleThread(int numThread) {
        this.numThread = numThread;
    }

    // Methods
    /**
     * Overrides the run() method from the class Thread.
     */
    @Override
    public void run () {
        for (int i = 0; i < 5; i++) { // Counts 5 numbers (0-4)
            System.out.println("Thread " + this.numThread + ": " + i);

            try {
                Thread.sleep(1000); // Waits 1 second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public int getNumThread() {
        return numThread;
    }

    public void setNumThread(int numThread) {
        this.numThread = numThread;
    }
}
