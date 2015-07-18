package edu.tj.common;

/**
 * All the examples of the book implement this. It introduces a name and cahpter
 * number for the example.
 * 
 * @author meddle
 */
public interface Program
{
  default String fromChapter() {
    return "Two";
  }

  String name();

  int chapter();

  void run();
}
