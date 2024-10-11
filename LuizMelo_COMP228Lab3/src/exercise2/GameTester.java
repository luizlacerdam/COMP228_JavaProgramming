package exercise2;

public abstract class GameTester {

  protected String name;
  protected boolean fulltime;

  public GameTester(String name, boolean fulltime) {
    this.name = name;
    this.fulltime = fulltime;
  }
  public abstract void salary();
}
