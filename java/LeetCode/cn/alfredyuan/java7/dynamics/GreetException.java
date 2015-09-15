package cn.alfredyuan.java7.dynamics;

public class GreetException extends Exception {

  private static final long serialVersionUID = 1679945624892165780L;

  /**
   * Creates a new instance of <code>GreetException</code> without detail
   * message.
   */
  public GreetException() {}

  /**
   * Constructs an instance of <code>GreetException</code> with the specified
   * detail message.
   * 
   * @param msg
   *          the detail message.
   */
  public GreetException(String msg) {
    super(msg);
  }
}
