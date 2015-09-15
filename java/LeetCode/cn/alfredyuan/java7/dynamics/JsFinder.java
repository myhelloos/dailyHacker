package cn.alfredyuan.java7.dynamics;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public class JsFinder {
  ScriptEngineManager manager;

  public JsFinder() {
    manager = new ScriptEngineManager();
  }

  public void greet() throws ScriptException {
    ScriptEngine engine = getJavaScriptEngine();
    if (engine == null) {
      throw new RuntimeException("找不到JavaScript语言执行引擎。");
    }
    engine.eval("println('Hello！');");
  }

  public void useDefaultBinding() throws ScriptException {
    ScriptEngine engine = getJavaScriptEngine();
    engine.put("name", "Alex");
    engine.eval("var message='Hello,'+name;");
    engine.eval("println(message);");
    Object obj = engine.get("message");
    System.out.println(obj);
  }

  public void useCustomBinding() throws ScriptException {
    ScriptEngine engine = getJavaScriptEngine();
    Bindings bindings = new SimpleBindings();
    bindings.put("hobby", "playing games");
    engine.eval("println('I like'+hobby);", bindings);
  }

  public void scriptToFile() throws IOException, ScriptException {
    ScriptEngine engine = getJavaScriptEngine();
    ScriptContext context = engine.getContext();
    context.setWriter(new FileWriter("output.txt"));
    context.setErrorWriter(new FileWriter("error.txt"));
    context.setReader(new FileReader("input.txt"));
    engine.eval("println('Hello World！');");
  }

  public void scriptContextAttribute() {
    ScriptEngine engine = getJavaScriptEngine();
    ScriptContext context = engine.getContext();
    context.setAttribute("name", "Alex", ScriptContext.GLOBAL_SCOPE);
    context.setAttribute("name", "Bob", ScriptContext.ENGINE_SCOPE);
    context.getAttribute("name");// 值为Bob
  }

  public void scriptContextBindings() throws ScriptException {
    ScriptEngine engine = getJavaScriptEngine();
    ScriptContext context = engine.getContext();
    Bindings bindings1 = engine.createBindings();
    bindings1.put("name", "Alex");
    context.setBindings(bindings1, ScriptContext.GLOBAL_SCOPE);
    Bindings bindings2 = engine.createBindings();
    bindings2.put("name", "Bob");
    context.setBindings(bindings2, ScriptContext.ENGINE_SCOPE);
    engine.eval("println(name);");
  }

  public void useScriptContextValues() throws ScriptException {
    ScriptEngine engine = getJavaScriptEngine();
    ScriptContext context = engine.getContext();
    Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
    bindings.put("name", "Alex");
    engine.eval("println(name);");// 输出Alex
  }

  public void attributeInBindings() throws ScriptException {
    ScriptEngine engine = getJavaScriptEngine();
    ScriptContext context = engine.getContext();
    context.setAttribute("name", "Alex", ScriptContext.ENGINE_SCOPE);
    engine.eval("println(name);");// 输出为Alex
  }

  public CompiledScript compile(String scriptText) throws ScriptException {
    ScriptEngine engine = getJavaScriptEngine();
    if (engine instanceof Compilable) {
      CompiledScript script = ((Compilable) engine).compile(scriptText);
      return script;
    }
    return null;
  }

  public void run(String scriptText) throws ScriptException {
    CompiledScript script = compile(scriptText);
    if (script == null) {
      return;
    }
    for (int i = 0; i < 100; i++) {
      script.eval();
    }
  }

  public void invokeFunction() throws ScriptException, NoSuchMethodException {
    ScriptEngine engine = getJavaScriptEngine();
    String scriptText = "function greet(name){println('Hello,'+name);}";
    engine.eval(scriptText);
    Invocable invocable = (Invocable) engine;
    invocable.invokeFunction("greet", "Alex");
  }

  public void invokeMethod() throws ScriptException, NoSuchMethodException {
    ScriptEngine engine = getJavaScriptEngine();
    String scriptText = "var human={getGreeting:function(name){return'Hello, '+name;}};";
    engine.eval(scriptText);
    Invocable invocable = (Invocable) engine;
    Object scope = engine.get("human");
    Object result = invocable.invokeMethod(scope, "getGreeting", "Alfred");
    System.out.println(result);
  }

  public void useInterface() throws ScriptException {
    ScriptEngine engine = getJavaScriptEngine();
    String scriptText = "function getGreeting(name){return'Hello, '+name;}";
    engine.eval(scriptText);
    Invocable invocable = (Invocable) engine;
    Greet greet = invocable.getInterface(Greet.class);
    System.out.println(greet.getGreeting("Alfred"));
  }

  private ScriptEngine getJavaScriptEngine() {
    // return manager.getEngineByName("JavaScript");
    // return manager.getEngineByExtension("js");
    return manager.getEngineByMimeType("text/javascript");
  }

  public static void main(String... args) {
    try {
      (new JsFinder()).useInterface();
    } catch (ScriptException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
