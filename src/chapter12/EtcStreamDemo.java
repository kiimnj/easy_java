package chapter12;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EtcStreamDemo {
  public static void main(String[] args) {
    IntStream iterate = IntStream.iterate(1, x -> x+2);
    IntStream ints = new Random().ints(0,10);
    Stream<Double> generate = Stream.generate(Math::random);
    IntStream range = IntStream.range(1, 5);
    range.forEach(System.out::println);
    IntStream rangeClosed = IntStream.rangeClosed(1, 5);
    rangeClosed.forEach(System.out::println);
  }
}
