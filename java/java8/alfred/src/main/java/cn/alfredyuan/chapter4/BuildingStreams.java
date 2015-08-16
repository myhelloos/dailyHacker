package cn.alfredyuan.chapter4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {
  public static void main(String... args) {
    // streams from values
    Stream<String> stream = Stream.of("Java 8 ", "Lambda ", "In ", "Action");
    stream.map(String::toUpperCase).forEach(System.out::println);

    // get an empty stream
    Stream<String> emptyStream = Stream.empty();

    // Streams from arrays
    int[] numbers = { 5, 4, 7, 7, 2, 2, 5, 5, 7, 5, 0, 5, 1, 6, 6, 1, 1, 3, 4,
        5, 6, 9, 6, 9, 7, 8, 2, 8, 0, 0, 8, 0, 2, 1, 3, 3, 9, 5, 2, 7, 4, 4, 6,
        9, 4, 9, 9, 7, 9, 8, 3, 2, 5, 4, 2, 2, 6, 8, 9, 4, 4, 4, 9, 7, 3, 2, 4,
        9, 3, 2, 7, 7, 1, 2, 2, 7, 2, 2, 7, 3, 3, 8, 0, 0, 8, 5, 8, 4, 3, 6, 1,
        6, 3, 8, 7, 0, 6, 2, 5 };
    int sum = Arrays.stream(numbers).sum();
    System.out.println(sum);

    // Streams from file
    long uniqueWords = 0;
    try (Stream<String> lines = Files.lines(
        Paths.get("src/main/java/resources/chapter5/data.txt"),
        Charset.defaultCharset())) {
      uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
          .distinct().count();
    } catch (IOException e) {
    }
    System.out.println(uniqueWords);

    // streams form functions: creating infinite streams
    Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

    // Fibonacci tuples series
    Stream
        .iterate(new int[] { 0, 1 },
            fib -> new int[] { fib[1], fib[0] + fib[1] })
        .limit(20)
        .map(t -> t[0])
        .forEach(System.out::println);
    
    // generate
    Stream.generate(Math::random)
      .limit(5)
      .forEach(System.out::println);
    
    // Fibonacci series
    IntSupplier fib = new IntSupplier() {
      private int preivous = 0;
      private int current = 1;
      @Override
      public int getAsInt() {
        int oldPrevious = this.preivous;
        int nextValue = this.preivous + this.current;
        this.preivous = this.current;
        this.current = nextValue;
        return oldPrevious;
      }
    };
    IntStream.generate(fib).skip(20).limit(20).forEach(System.out::println);
  }
}
