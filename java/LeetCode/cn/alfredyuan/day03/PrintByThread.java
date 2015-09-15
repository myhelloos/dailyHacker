package cn.alfredyuan.day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class PrintByThread {
  final static String IN_FILE = "inputs.txt";
  final static String OUT_FILE = "outputs";
  final static int THREAD_NUMBER=5, NUMBERS = 2000, TOTAL_NUMBR = 1_0000;
  public static void main(String... args) {
    try {
      PrintWriter pw = new PrintWriter(new FileWriter(new File(IN_FILE)), true);
      Random random = new Random();
      for (int i=0; i<TOTAL_NUMBR; ++i) {
        pw.print(Math.abs(random.nextInt())%100 + " ");
      }
      pw.flush();
      pw.close();
      
      BufferedReader reader = new BufferedReader(new FileReader(IN_FILE));
      String str = reader.readLine();
      reader.close();
      String[] strs = str.split(" ");
      int j=0;
      for (int i=0; i<THREAD_NUMBER; ++i) {
        int[] records = new int[NUMBERS];
        for (int k=0; k<NUMBERS; ++k, ++j) {
          records[k] = Integer.parseInt(strs[j]);
        }
        PrintWriter writer = new PrintWriter(new FileWriter(new File(OUT_FILE+ i + ".txt")), true);
        ThreadGroup group = new ThreadGroup(records, writer);
        new Thread(group).start();
        new Thread(group).start();
      }
    } catch(FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class ThreadGroup implements Runnable {
  private static int count = 0; // all ThreadGroup share one static count, which used to record the total output number
  private static Object lock = new Object();    // only can change count after get the lock
  public static final int EVEN = 0;
  public static final int ODD = 1;
  public static final int PRINT_TIME = 10;
  public static final int THREAD_PRINT_NUMBER = 1_000;
  public static final int TOTAL_PRINT_NUMBER = 10_000;
  private int type;
  private int records[];
  private PrintWriter writer; // each group share one writer to write into same file
  private int oddPoint = 0; // the start location of print odd number each time
  private int evenPoint = 0; // the start location of print even number each time
  
  public ThreadGroup(int[] records, PrintWriter writer) {
    this.records = records;
    this.writer = writer;
    this.type = EVEN;
  }

  @Override
  public void run() {
    while(print());
  }
  
  private synchronized boolean print() {
    for (int i=0; i < PRINT_TIME; ) {
      if (oddPoint >= records.length && evenPoint >= records.length) {
        notifyAll();
        return false;
      }
      if ((oddPoint >= records.length && type == ODD)
          || (evenPoint >= records.length && type == EVEN)) {
        break;
      }
      if (EVEN == type) {
        if (0 == (records[evenPoint] % 2)) {
          ++i;
          writer.print(records[evenPoint] + " ");
          writer.flush();
          synchronized(lock) {
            ++count;
            if (0 == count % THREAD_PRINT_NUMBER) {
              System.out.println("当前完成数量: " + count);
              if (TOTAL_PRINT_NUMBER == count) {
                System.out.println("Done!");
              }
            }
          }
        }
        ++evenPoint;
      } else {
        if (oddPoint == records.length) {
          System.err.println("2");
        }
        if (1 == (records[oddPoint] % 2)) {
          ++i;
          writer.print(records[oddPoint] + " ");
          writer.flush();
          synchronized(lock) {
            ++count;
            if (0 == count % THREAD_PRINT_NUMBER) {
              System.out.println("当前完成数量: " + count);
              if (TOTAL_PRINT_NUMBER == count) {
                System.out.println("Done!");
              }
            }
          }
        }
        ++oddPoint;
      }
    }
    type = ODD ^ type;
    notifyAll();
    try {
      wait();
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
    return true;
  }
}
