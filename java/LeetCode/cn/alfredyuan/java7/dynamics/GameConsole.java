package cn.alfredyuan.java7.dynamics;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class GameConsole extends JsScriptRunner implements Runnable {
  private GameConfig config;

  public GameConsole(GameConfig config) {
    this.config = config;
  }

  public void executeCommand(String command) throws ScriptException {
    ScriptEngine engine = getJavaScriptEngine();
    if (command.indexOf("println") == -1) {
      command = "println(" + command + ");";
    }
    engine.eval(command, config.getScriptBindings());
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String line = scanner.nextLine();
      if ("quit".equals(line)) {
        break;
      }
      try {
        executeCommand(line);
      } catch (ScriptException ex) {
        System.err.println("错误的命令！");
      }
    }
  }
}
