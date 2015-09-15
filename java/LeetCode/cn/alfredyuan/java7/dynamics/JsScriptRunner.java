package cn.alfredyuan.java7.dynamics;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public abstract class JsScriptRunner {
  protected ScriptEngine getJavaScriptEngine() {
    ScriptEngineManager manager = new ScriptEngineManager();
    // ScriptEngine engine = manager.getEngineByName("JavaScript");
    // ScriptEngine engine = manager.getEngineByExtension("js");
    ScriptEngine engine = manager.getEngineByMimeType("text/javascript");
    if (engine == null) {
      throw new RuntimeException("找不到JavaScript语言执行引擎。");
    }
    return engine;
  }
}
