package cn.alfredyuan.chapter5;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Arrays;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.joining;

public class PuttingIntoPractice {
  public static void main(String... args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario","Milan");
    Trader alan = new Trader("Alan","Cambridge");
    Trader brian = new Trader("Brian","Cambridge");
    
    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300), 
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),  
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );  
    
    // find all transactions in 2011 and sort by value
    List<Transaction> tr2011 = transactions.stream()
        .filter(t -> 2011 == t.getYear())
        .sorted(comparing(Transaction::getValue))
        .collect(toList());
    System.out.println(tr2011);
    
    // what are all the unique cities where the traders work
    Set<String> cities = transactions.stream()
        .map(transaction -> transaction.getTrader().getCity())
        .collect(toSet());
    System.out.println(cities);
    
    // find all traders from Cambridge and sort them by name
    List<Trader> traders = transactions.stream()
        .map(Transaction::getTrader)
        .filter(trader -> "Cambridge".equals(trader.getCity()))
        .distinct()
        .sorted(comparing(Trader::getName))
        .collect(toList());
    System.out.println(traders);
    
    // return a string of all trader's names sorted alphabetically
    String tradeStr = transactions.stream()
        .map(transaction -> transaction.getTrader().getName())
        .distinct()
        .sorted()
        .collect(joining(", "));
    System.out.println(tradeStr);
    
    // are any traders based in Milan
    boolean milanBased = transactions.stream()
        .anyMatch(transaction -> "Milan".equals(
            transaction.getTrader().getCity()));
    System.out.println(milanBased);
        
    // print all transactions' values from the traders living in Cambridge
    transactions.stream()
      .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
      .map(Transaction::getValue)
      .forEach(System.out::println);
    
    // what's the highest value of all transactions
    Optional<Integer> highestValue = transactions.stream()
        .map(Transaction::getValue)
        .max(Integer::compare);
    System.out.println(highestValue);
    
    highestValue = transactions.stream()
        .map(Transaction::getValue)
        .reduce(Integer::max);
    System.out.println(highestValue);
    
    // find the transaction with smallest value
    Optional<Transaction> smallestTransaction = transactions.stream()
        .reduce((t1, t2) ->
          t1.getValue() < t2.getValue() ? t1 : t2
        );
    System.out.println(smallestTransaction);
  }
}
