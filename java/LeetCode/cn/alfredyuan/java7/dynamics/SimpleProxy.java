package cn.alfredyuan.java7.dynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class SimpleProxy {

  public static <T> T makeProxy(Class<T> clazz, final T object) {
    InvocationHandler handler = new LoggingInvocationHandler(object);
    ClassLoader cl = object.getClass().getClassLoader();
    return (T) Proxy.newProxyInstance(cl, new Class<?>[] { clazz }, handler);
  }

  public static Object proxyAll(final Object object) {
    InvocationHandler handler = new LoggingInvocationHandler(object);
    ClassLoader cl = object.getClass().getClassLoader();
    Class<?>[] interfaces = object.getClass().getInterfaces();
    return Proxy.newProxyInstance(cl, interfaces, handler);
  }

  public static void useProxy() {
    List<String> list = new ArrayList<>();
    InvocationHandler handler = new LoggingInvocationHandler(list);
    ClassLoader cl = SimpleProxy.class.getClassLoader();
    List<String> obj = (List<String>) Proxy.newProxyInstance(cl,
        new Class[]
    { List.class }, handler);
    obj.add("Good");
    System.out.println(obj.get(0));
  }

  public static void useGenericProxy() {
    String str = "Hello World";
    Comparable proxy = makeProxy(Comparable.class, str);
    proxy.compareTo("Good");
    List<String> list = new ArrayList<String>();
    list = makeProxy(List.class, list);
    list.add("Hello");
  }

  public static void useAllProxy() {
    String str = "Hello World";
    CharSequence cs = (CharSequence) proxyAll(str);
    cs.length();
    cs.charAt(0);
    cs.toString();
  }

  /**
   * @param args
   *          the command line arguments
   */
  public static void main(String[] args) {
    useProxy();
    useGenericProxy();
    useAllProxy();
  }
}
