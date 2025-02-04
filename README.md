# threadVSrunnable
The main purpose for this project is to show the difference between creating a class that
implements the interface Runnable and another one that extends the class Thread.
<br>
Although it is not directly shown in the project, the class that extends Thread can't extend any other
class because how inheritance works in Java, allowing just one class being extended. On the other hand,
the class that implements Runnable can extend any other class because a single class can implement any
number of interfaces.
<br><br>
## Classes
<ul>
  <li>
    Main: inside, I created a menu that shows the options the user can choose (threads created with different classes or exit) and prove that for the
    user there's no difference between the different ways to create threads. It also includes the main() method to execute the program.
  </li>
  <li>
    ExampleThread: it is a class that shows how to extend the class Thread overwriting the method run().
  </li>
  <li>
    ExampleRunnable: a class that shows how to implement the Runnable interface also overwriting the method run().
    This class could extend any other class as we are implementing an interface instead of extending the class Thread.
  </li>
</ul>
<br><br>
