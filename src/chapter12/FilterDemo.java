package chapter12;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class FilterDemo {
  public static void main(String[] args) {
    String[] sa = {"a1","b1","c1","c2","c3"};
    Arrays.stream(sa)
        .filter(s -> s.startsWith("c"))
        .skip(1) //1개 스킵하고 forEach
        .forEach(System.out::println);

    IntStream ints = new Random().ints(0,10);
    ints.limit(10)
        .filter(x -> x % 2 == 0)
        .forEach(System.out::println);

    List<Nation> nations = Nation.nations;
    nations.stream()
        .filter(x -> x.getPopulation() >= 100)
        .limit(2)
        .forEach(System.out::println);
  }
}
