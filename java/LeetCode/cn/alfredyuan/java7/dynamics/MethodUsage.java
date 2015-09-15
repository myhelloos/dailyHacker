package cn.alfredyuan.java7.dynamics;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MethodUsage {
  public void useMethod()
      throws ReflectiveOperationException {
    MethodContainer mc = new MethodContainer();
    String name = "Alfred";
    Method publicMethod = MethodContainer.class
        .getDeclaredMethod("publicMethod", String.class);
    publicMethod.invoke(mc, name);
    Method privateMethod = MethodContainer.class
        .getDeclaredMethod("privateMethod", String.class);
    privateMethod.setAccessible(true);
    privateMethod.invoke(mc, name);
  }

  public static void main(String[] args) {
    MethodUsage mu = new MethodUsage();
    try {
      mu.useMethod();
    } catch (ReflectiveOperationException ex) {
      Logger.getLogger(MethodUsage.class.getName()).log(Level.SEVERE, null, ex.getCause());
    }
  }
}
