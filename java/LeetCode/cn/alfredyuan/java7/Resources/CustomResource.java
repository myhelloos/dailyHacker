package cn.alfredyuan.java7.Resources;

public class CustomResource implements AutoCloseable {
  public void close() throws Exception {
    System.out.println("进行资源释放。");
  }

  public void useCustomResource() throws Exception {
    try (CustomResource resource = new CustomResource()) {
      System.out.println("使用资源。");
    }
  }
}
