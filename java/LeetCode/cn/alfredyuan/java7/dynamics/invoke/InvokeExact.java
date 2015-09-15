package cn.alfredyuan.java7.dynamics.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class InvokeExact {

  public void invokeExact() throws Throwable {
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    MethodType type = MethodType.methodType(String.class, int.class, int.class);
    MethodHandle mh = lookup.findVirtual(String.class, "substring", type);
    String str = (String) mh.invoke("Hello World", 1, 3);
    System.out.println(str);

    MethodHandle mh2 = lookup.findVirtual(String.class, "getChars", MethodType
        .methodType(void.class, int.class, int.class, char[].class, int.class));
    char[] dest = new char[2];
    mh2.invokeExact("Hello World", 0, 2, dest, 0);
    System.out.println(dest);

    MethodHandle mh3 = lookup.findStatic(Math.class, "min",
        MethodType.methodType(int.class, int.class, int.class));
    System.out.println((int) mh3.invoke(3, 4));
  }

  /**
   * @param args
   *          the command line arguments
   */
  public static void main(String[] args) {
    try {
      new InvokeExact().invokeExact();
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }
}
