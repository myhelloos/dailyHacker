package cn.alfredyuan.java7.dynamics.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectMethodHandle {

  public void unreflect() throws Throwable {
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    Constructor<String> constructor = String.class.getConstructor(byte[].class);
    lookup.unreflectConstructor(constructor);
    Method method = String.class.getMethod("substring", int.class, int.class);
    lookup.unreflect(method);

    Method privateMethod = ReflectMethodHandle.class
        .getDeclaredMethod("privateMethod");
    lookup.unreflectSpecial(privateMethod, ReflectMethodHandle.class);

    Field field = ReflectMethodHandle.class.getField("name");
    lookup.unreflectGetter(field);
    lookup.unreflectSetter(field);
  }

  private void privateMethod() {}

  public String name;

  public static void main(String[] args) throws Throwable {
    ReflectMethodHandle rmh = new ReflectMethodHandle();
    rmh.unreflect();
  }
}
