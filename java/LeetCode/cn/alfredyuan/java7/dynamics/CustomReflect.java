package cn.alfredyuan.java7.dynamics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomReflect {
  public static void invokeSetter(Object obj, String field, Object value)
      throws NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    String methodName = "set" + field.substring(0, 1).toUpperCase()
        + field.substring(1);
    Class<?> clazz = obj.getClass();
    Method method = clazz.getMethod(methodName, value.getClass());
    method.invoke(obj, value);
  }
}
