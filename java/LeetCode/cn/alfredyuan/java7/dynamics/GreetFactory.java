package cn.alfredyuan.java7.dynamics;

import java.lang.reflect.Proxy;

public class GreetFactory {

  public static GreetV2 adaptGreet(GreetV1 greet) {
    GreetAdapter adapter = new GreetAdapter(greet);
    ClassLoader cl = greet.getClass().getClassLoader();
    return (GreetV2) Proxy.newProxyInstance(cl,
        new Class<?>[] { GreetV2.class }, adapter);
  }
}
