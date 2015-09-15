package cn.alfredyuan.java7.dynamics.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleLookup extends MethodHandleLookupParent {

  public void lookupMethod()
      throws NoSuchMethodException, IllegalAccessException {
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    // 构造方法
    MethodHandle constructor = lookup.findConstructor(String.class,
        MethodType.methodType(void.class, byte[].class));
    System.out.println(constructor);
    // String.substring
    MethodHandle substring = lookup.findVirtual(String.class, "substring",
        MethodType.methodType(String.class, int.class, int.class));
    System.out.println(substring);
    // String.format
    MethodHandle format = lookup.findStatic(String.class, "format",
        MethodType.methodType(String.class, String.class, Object[].class));
    System.out.println(format);
  }

  public void lookupFieldAccessor()
      throws NoSuchFieldException, IllegalAccessException {
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    MethodHandle getName = lookup.findGetter(Sample.class, "name",
        String.class);
    MethodHandle setName = lookup.findSetter(Sample.class, "name",
        String.class);
    MethodHandle getValue = lookup.findStaticGetter(Sample.class, "value",
        int.class);
    MethodHandle setValue = lookup.findStaticSetter(Sample.class, "value", int.class);
    Sample sample = new Sample();
    try {
      setName.invoke(sample, "Alfred");
      setValue.invoke(3);
      System.out.println(getName.invoke(sample) + "; " + getValue.invoke());
    } catch (Throwable e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

  public MethodHandle lookupSpecial()
      throws NoSuchMethodException, IllegalAccessException, Throwable {
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    MethodHandle mh = lookup.findSpecial(MethodHandleLookup.class,
        "protectedMethod", MethodType.methodType(void.class),
        MethodHandleLookup.class);
    System.out.println(mh.type());
    mh.invoke(this);
    return mh;
  }

  public void lookupSpecialNoDispatch() throws Throwable {
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    MethodHandle mh = lookup.findSpecial(Object.class, "toString",
        MethodType.methodType(String.class), Object.class);
    Object result = mh.invoke(this);
    System.out.println(result);
  }

  private void privateMethod() {
    System.out.println("PRIVATE");
  }

  protected void protectedMethod() {
    System.out.println("OVERRIDE");
  }

  public static class MHHH extends MethodHandleLookup {

  }

  public String toString() {
    return this.getClass().toString();
  }

  public static void main(String[] args) {
    MethodHandleLookup lookup = new MethodHandleLookup();
    try {
//      lookup.lookupMethod();
       lookup.lookupFieldAccessor();
//      lookup.lookupSpecial();
      // lookup.lookupSpecialNoDispatch();
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
}
