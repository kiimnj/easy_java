package chapter12;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StaticDemo {
  public static void main(String[] args) {
    IntStream is = IntStream.of(1,2,3,4,5,6,7,8,9,10);
    System.out.println("is.sum() : " + is.sum());
    is = IntStream.of(1,2,3,4,5,6,7,8,9,10);
    System.out.println("is.average() : " + is.average()); //나누는거라 옵셔널

    Stream<String> ss = Stream.of("a", "b", "c", "d", "e");
    System.out.println("count : " + ss.count());
    ss = Stream.of("a", "b", "c", "d", "e");
    System.out.println("max : " + ss.max((x, y) -> x.hashCode() - y.hashCode()).get());

    Stream<String> ss1 = Stream.of("a", "bb", "ccc", "d", "ee");
    System.out.println("max : " + ss1.max((x, y) -> x.length() - y.length()).get());
  }
}
