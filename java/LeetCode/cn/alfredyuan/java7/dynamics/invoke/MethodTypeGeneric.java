package cn.alfredyuan.java7.dynamics.invoke;

import java.lang.invoke.MethodType;

public class MethodTypeGeneric {

  public void generateGenericMethodTypes() {
    MethodType mt1 = MethodType.genericMethodType(3);
    MethodType mt2 = MethodType.genericMethodType(2, true);

    System.out.println(mt1);
    System.out.println(mt2);
    System.out.println(mt1.parameterCount());
    System.out.println(mt2.parameterCount());
  }

  /**
   * @param args
   *          the command line arguments
   */
  public static void main(String[] args) {
    new MethodTypeGeneric().generateGenericMethodTypes();
  }
}
