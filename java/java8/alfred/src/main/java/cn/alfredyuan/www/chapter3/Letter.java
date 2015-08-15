package cn.alfredyuan.www.chapter3;

public class Letter {
  public static String addHeader(String text) {
    return "From Raoul, Mario and Alan: " + text;
  }

  public static String addFooter(String text) {
    return text + " Kind Regards";
  }

  public static String checkSpelling(String text) {
    return text.replaceAll("labda", "lambda");
  }
}
