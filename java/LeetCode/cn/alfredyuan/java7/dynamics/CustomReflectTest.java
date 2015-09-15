package cn.alfredyuan.java7.dynamics;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class CustomReflectTest {
  private static class MyObject {
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  @Test
  public void testInvokeSetter() {
    MyObject obj = new MyObject();
    String name = "Alfred";
    try {
      CustomReflect.invokeSetter(obj, "name", name);
    } catch (NoSuchMethodException ex) {
      Logger.getLogger(CustomReflect.class.getName()).log(Level.SEVERE, null,
          ex);
    } catch (InvocationTargetException ex) {
      Logger.getLogger(CustomReflect.class.getName()).log(Level.SEVERE, null,
          ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(CustomReflect.class.getName()).log(Level.SEVERE, null,
          ex);
    }
    assertEquals(name, obj.getName());
  }

}
