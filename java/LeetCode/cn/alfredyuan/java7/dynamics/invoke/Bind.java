package cn.alfredyuan.java7.dynamics.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Bind {

  public void bindTo() throws Throwable {
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    MethodHandle mh = lookup.findVirtual(String.class, "length",
        MethodType.methodType(int.class));
    int len = (int) mh.invoke("Hello");
    System.out.println(len);
    mh = mh.bindTo("Hello World");
    len = (int) mh.invoke();
    System.out.println(len);
    mh = lookup.findVirtual(String.class, "substring",
        MethodType.methodType(String.class, int.class, int.class));
    mh = mh.asType(mh.type().wrap());
    mh = mh.bindTo("Hello World").bindTo(3).bindTo(11);
    System.out.println(mh.invoke());
  }

  public void multipleBindTo() throws Throwable {
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    MethodHandle mh = lookup.findVirtual(String.class, "indexOf",
        MethodType.methodType(int.class, String.class, int.class));
    mh = mh.bindTo("Hello").bindTo("l");
    System.out.println(mh.invoke(2));
  }

  public static void main(String[] args) throws Throwable {
    Bind bind = new Bind();
    bind.bindTo();
    bind.multipleBindTo();
  }
}
