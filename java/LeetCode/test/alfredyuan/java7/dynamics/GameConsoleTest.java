package test.alfredyuan.java7.dynamics;

import org.junit.Before;
import org.junit.Test;

import cn.alfredyuan.java7.dynamics.GameConfig;
import cn.alfredyuan.java7.dynamics.GameConsole;

public class GameConsoleTest {
  GameConsole game;
  @Before
  public void initTest() {
    game = new GameConsole(new GameConfig());
  }

  @Test
  public void testRun() {
    game.run();
  }

}
