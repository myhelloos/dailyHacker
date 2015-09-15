package cn.alfredyuan.java7.dynamics;

import java.util.Arrays;

public class VarargsConstructor {
  public VarargsConstructor(String address, String... names) {
    System.out.println("in VarargsConstructor with " + address + " and " + Arrays.toString(names));
  }
}
