package cn.alfredyuan.java7.Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MultipleResourcesUsage {
  public void copyFile(String fromPath, String toPath) throws IOException {
    try (InputStream input = new FileInputStream(fromPath);
        OutputStream output = new FileOutputStream(toPath)) {
      byte[] buffer = new byte[8192];
      int len = -1;
      while ((len = input.read(buffer)) != -1) {
        output.write(buffer, 0, len);
      }
    }
  }
}
