package chapter12;

import java.util.Optional;

public class FindDemo {
  public static void main(String[] args) {
    Optional<Nation> first = Nation.nations.stream().findFirst();
    Optional<Nation> second = Nation.nations.stream().skip(1).findFirst();
    //ctrl alt v - Optional인 이유: null일 수도 있기 때문
    System.out.println(first.get());
    System.out.println(second.get());

//    Optional<Nation> any = Nation.nations.stream().filter(x -> x.isIsland()).findAny();
    Optional<Nation> any = Nation.nations.stream().filter(Nation::isIsland).findAny();
    System.out.println(any.get());
  }
}
