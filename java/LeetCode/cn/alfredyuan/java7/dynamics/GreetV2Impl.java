package cn.alfredyuan.java7.dynamics;

public class GreetV2Impl implements GreetV2 {

  @Override
  public String greet(String username) {
    return "<Greet V2>" + username;
  }

}
