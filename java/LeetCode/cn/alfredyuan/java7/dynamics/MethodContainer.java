package cn.alfredyuan.java7.dynamics;

public class MethodContainer {
  private void privateMethod(String name) {
    System.out.println("Inside the privateMethod with " + name);
  }

  public void publicMethod(String name) {
    System.out.println("Inside the publicMethod with " + name);
  }
}
