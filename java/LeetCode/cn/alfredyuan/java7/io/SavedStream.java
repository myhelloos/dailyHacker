package cn.alfredyuan.java7.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SavedStream {

  private InputStream input;
  private byte[]      data = new byte[0];

  public SavedStream(InputStream input) throws IOException {
    this.input = input;
    save();
  }

  private void save() throws IOException {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int len = -1;
    while ((len = input.read(buffer)) != -1) {
      output.write(buffer, 0, len);
    }
    data = output.toByteArray();
  }

  public InputStream getInputStream() {
    return new ByteArrayInputStream(data);
  }
}
