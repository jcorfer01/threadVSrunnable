package threadVSrunnable;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main purpose for this project is to show the difference between creating a class that
 * implements the interface Runnable and another one that extends the class Thread.
 * <br><br>
 * Although it is not directly shown in the project, the class that extends Thread can't extend any other class
 * because of how inheritance works in Java, allowing just one class to be extended. On the other hand, the class
 * that implements Runnable can extend any other class because a single class can implement any number of interfaces.
 * <br><br>
 * Inside the Main class, I created a menu that shows the options the user can choose and prove that for the
 * user there's no difference between the different ways to create threads.
 *
 * @author      Jorge Correyero
 * @version     1.0
 */

public class Main {
    /**
     * Method to show the menu to the user.
     */
    private static void menuShow() {
        System.out.print("""
                MENU:
                1) Extend Thread.
                2) Implement Runnable.
                3) Exit.
                
                Choose an option:
                """);
    }

    /**
     * Method to execute the user option.
     * <br><br>
     * In case the user chooses option 1, the program will create 3 threads from the class that
     * extends Thread and run them concurrently.
     * <br>
     * If the user chooses option 2, the threads are created from another class that implements Runnable.
     * <br>
     * The third option will exit the program.
     *
     * @param option Option chosen from the menu by the user.
     */
    private static void menuExecute (int option) {
        switch (option) {
            case 1: // Extend Thread
                ArrayList<ExampleThread> threadList = new ArrayList<>();

                for (int i = 1; i <= 3; i++) { // loop to create 3 threads
                    ExampleThread counterThread = new ExampleThread(i);
                    threadList.add(counterThread);
                    counterThread.start();
                }

                // Wait for all threads to finish
                for (ExampleThread t : threadList) {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;

            case 2: // Implement Runnable
                ArrayList<Thread> runnableThreads = new ArrayList<>();

                for (int i = 1; i <= 3; i++) { // loop to create 3 threads
                    ExampleRunnable example = new ExampleRunnable();
                    Thread counterThread = new Thread(example);
                    counterThread.setName(Integer.toString(i)); // set the Thread name
                    runnableThreads.add(counterThread);
                    counterThread.start();
                }

                // Wait for all threads to finish
                for (Thread t : runnableThreads) {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;

            case 3: // Exit
                System.out.println("Exiting the program...");
                break;

            default: // Invalid input
                System.out.println("Invalid Option.\n");
        }
    }

    /**
     * Our main method. With the method menu(), it will show the difference between
     * extending Thread and implementing Runnable.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int op = -1; // option chosen by the user

        do {
            menuShow();
            try {
                op = scan.nextInt();
            }
            catch(InputMismatchException ime) {
                System.out.println("Invalid input, please enter a numeric number");
                scan.next(); // Clear the scanner buffer and reset the op var
                op = -1;
            }
            menuExecute(op);
        } while (op != 3);

        scan.close();
    }
}