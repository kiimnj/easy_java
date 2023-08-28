package chapter12;

import java.util.stream.IntStream;

public class LazinessDemo {
  public static void main(String[] args) {
    IntStream is = IntStream.rangeClosed(1, 5);

    is.filter(x -> {
      System.out.println("filter : " + x);
      return x % 2 == 0;
    }).map(x -> {
      System.out.println("map : " + x);
      return x * x;
    }).forEach(x -> System.out.println("forEach : " + x)); //forEach(조급한 연산) 전에는 프린트 안됨
  }
}

