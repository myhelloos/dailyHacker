package cn.alfredyuan.java7.dynamics;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConstructorUsage {

  private String outerValue;

  public void useNestedClassConstructor() throws Exception {
    Constructor<StaticNestedClass> sncc = StaticNestedClass.class
        .getDeclaredConstructor(String.class);
    sncc.newInstance("Alfred");
    Constructor<NestedClass> ncc = NestedClass.class
        .getDeclaredConstructor(ConstructorUsage.class, int.class);
    NestedClass ic = ncc.newInstance(this, Integer.MAX_VALUE);
  }

  public void useVarargsConstructor() throws Exception {
    Constructor<VarargsConstructor> constructor = VarargsConstructor.class
        .getDeclaredConstructor(String.class, String[].class);
    constructor.newInstance("City", (Object) (new String[] { "A", "B", "C" }));
  }

  static class StaticNestedClass {
    public StaticNestedClass(String name) {
      System.out.println("In StaticNestedClass with " + name);
    }
  }

  class NestedClass {
    public NestedClass(int count) {
      System.out.println("in NestedClass with " + count);
      outerValue = "";
    }
  }

  public static void main(String[] args) {
    ConstructorUsage cu = new ConstructorUsage();
    try {
      cu.useNestedClassConstructor();
      cu.useVarargsConstructor();
    } catch (Exception ex) {
      Logger.getLogger(ConstructorUsage.class.getName()).log(Level.SEVERE, null,
          ex);
    }
  }
}
