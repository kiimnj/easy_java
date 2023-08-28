package chapter12;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatchDemo {
  public static void main(String[] args) {
    boolean b = Stream.of("a1", "b1", "c1").anyMatch(x -> x.startsWith("c"));
    System.out.println(b);

    boolean b1 = IntStream.of(1, 3, 5, 7, 9).allMatch(n -> n % 2 == 1);
    System.out.println(b1);

    //스트림 대신 for if로
    int[] ia = {1,3,5,7,9};
    boolean odd = true;
    for (int i : ia) {
      if (i % 2 != 1) {
        odd = false;
        break;
      }
    }
    System.out.println(odd);

    boolean b2 = IntStream.of(1, 3, 5, 7, 9).noneMatch(n -> n % 2 == 0);
    System.out.println(b1);

    List<Nation> nations = Nation.nations;
    boolean b3 = nations.stream().allMatch(x -> x.getPopulation() >= 100);
    System.out.println(b3);
  }
}
