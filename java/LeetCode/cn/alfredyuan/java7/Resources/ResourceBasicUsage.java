package cn.alfredyuan.java7.Resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResourceBasicUsage {
  public String readFile(String path) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      StringBuilder builder = new StringBuilder();
      String line = null;
      while (null != (line = reader.readLine())) {
        builder.append(line);
        builder.append(String.format("%n"));
      }
      return builder.toString();
    }
  }
}
