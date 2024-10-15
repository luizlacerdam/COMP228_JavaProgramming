package exercise3;

public class Freelancer implements Payable{
  private int tasksCompleted;
  private double paymentPerTask;

  public Freelancer(int tasksCompleted, double paymentPerTask) {
    this.tasksCompleted = tasksCompleted;
    this.paymentPerTask = paymentPerTask;
  }

  @Override
  public double pay() {
    return tasksCompleted * paymentPerTask;
  }
}
