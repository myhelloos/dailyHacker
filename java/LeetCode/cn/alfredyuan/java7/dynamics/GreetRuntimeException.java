package cn.alfredyuan.java7.dynamics;

public class GreetRuntimeException extends RuntimeException {

  private static final long serialVersionUID = -7768217951019885958L;

  /**
   * Creates a new instance of <code>GreetRuntimeException</code> without detail
   * message.
   */
  public GreetRuntimeException() {}

  /**
   * Constructs an instance of <code>GreetRuntimeException</code> with the
   * specified detail message.
   * 
   * @param msg
   *          the detail message.
   */
  public GreetRuntimeException(String msg) {
    super(msg);
  }

  public GreetRuntimeException(Throwable cause) {
    super(cause);
  }

  public GreetRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }

}
