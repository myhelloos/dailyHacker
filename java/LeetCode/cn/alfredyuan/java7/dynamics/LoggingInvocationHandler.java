package cn.alfredyuan.java7.dynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingInvocationHandler implements InvocationHandler {

  private static final Logger LOGGER = Logger
      .getLogger(LoggingInvocationHandler.class.getName());
  private Object receiverObject;

  public LoggingInvocationHandler(Object thisObject) {
    this.receiverObject = thisObject;
  }

  public Object invoke(Object proxy, Method method, Object[] args)
      throws Throwable {
    LOGGER.log(Level.INFO,
        "调用方法 " + method + "; 参数为 " + Arrays.deepToString(args));
    Object result = method.invoke(receiverObject, args);
    LOGGER.log(Level.INFO,
        "调用方法 " + method + "的结果为 " + result);
    return result;
  }
}
