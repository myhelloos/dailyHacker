package cn.alfredyuan.java7.dynamics;

public class GreetV1Impl implements GreetV1 {

  @Override
  public String greet(String name, String gender) throws GreetException {
    if (gender == null) {
      throw new GreetException("性别不能为空！");
    }
    return "<Greet V1>" + name + (gender.equals("男") ? " 先生" : " 女士");
  }

}
