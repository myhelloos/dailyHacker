package cn.alfredyuan.java7.dynamics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultipleInterfacesProxy {
  private final String HELLO = "Hello";
  private final String WORLD = "World";

  public void proxyMultipleInterfaces() throws Throwable {
    List<String> receiverObj = new ArrayList<String>();
    InvocationHandler handler = new LoggingInvocationHandler(receiverObj);
    Class<?> proxyClass = Proxy.getProxyClass(
        MultipleInterfacesProxy.class.getClassLoader(),
        new Class<?>[] { List.class, Set.class });
    Object proxy = proxyClass
        .getConstructor(new Class[] { InvocationHandler.class })
        .newInstance(new Object[] { handler });
    List<String> list = (List<String>) proxy;
    list.add(HELLO);
    list.add(WORLD);
    Set<String> set = (Set<String>) proxy;
    set.add(HELLO);
    set.add(WORLD);
    set.add(HELLO);
    set.add(WORLD);
    for (String str : list) {
      System.out.println(str);
    }
  }

  /**
   * @param args
   *          the command line arguments
   */
  public static void main(String[] args) throws Throwable {
    MultipleInterfacesProxy proxy = new MultipleInterfacesProxy();
    proxy.proxyMultipleInterfaces();
  }
}
