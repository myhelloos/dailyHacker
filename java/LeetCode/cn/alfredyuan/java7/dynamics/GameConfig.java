package cn.alfredyuan.java7.dynamics;

import javax.script.Bindings;
import javax.script.SimpleBindings;

public class GameConfig {
  public int screenWidth;

  public int screenHeight;

  private Bindings bindings = new SimpleBindings();

  public GameConfig() {
    this.initBindings();
  }

  private void initBindings() {
    bindings.put("config", this);
  }

  public Bindings getScriptBindings() {
    return bindings;
  }

  public int getScreenWidth() {
    return screenWidth;
  }
}
