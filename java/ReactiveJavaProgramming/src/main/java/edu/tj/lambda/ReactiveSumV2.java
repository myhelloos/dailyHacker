package edu.tj.lambda;

import java.util.regex.Pattern;

import rx.Observable;
import rx.observables.ConnectableObservable;

import edu.tj.common.CreateObservable;
import edu.tj.common.Program;

public class ReactiveSumV2 implements Program
{
  
  public static Observable<Double> varStream(
      final String name, Observable<String> input) {
    final Pattern pattern = Pattern.compile(
        "\\s*" + name + "\\s*[:|=]\\s*(-?\\d+\\.?\\d*)$"
    );
    
    return input
        .map(pattern::matcher)
        .filter(m -> m.matches() && m.group(1) != null)
        .map(matcher -> matcher.group(1))
        .map(Double::parseDouble);
  }
  
  public static void ractiveSum(
      Observable<Double> a,
      Observable<Double> b) {
    Observable
       .combineLatest(a, b, (x, y) -> x + y)
       .subscribe(
           sum -> System.out.println("update: a + b = " + sum),
           error -> {
             System.out.println("Got an error!");
             error.printStackTrace();
           },
           () -> System.out.println("Existing...")
       );
  }

  @Override
  public void run()
  {
    ConnectableObservable<String> input = CreateObservable.from(System.in);
    
    Observable<Double> a = varStream("a", input);
    Observable<Double> b = varStream("b", input);
    
    ractiveSum(a, b);
    
    input.connect();
  }

  @Override
  public String name()
  {
    return "Reactive Sum, lambdas version)";
  }

  @Override
  public int chapter()
  {
    return 2;
  }

  public static void main(String[] args)
  {
    new ReactiveSumV2().run();
  }

}
