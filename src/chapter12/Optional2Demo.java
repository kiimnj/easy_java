package chapter12;

import java.util.Optional;

public class Optional2Demo {
  public static void main(String[] args) {
    String s1 = "Hello";
    String s2 = null;

    Optional<String> o1 = Optional.ofNullable(s1);
    Optional<String> o2 = Optional.ofNullable(s2);

    if(o1.isPresent()) {
      Util.print(o1.get());
    } else {
      System.out.println("데이터가 없습니다.");
    }

    if(o2.isPresent()) {
      Util.print(o2.get());
    } else {
      System.out.println("데이터가 없습니다.");
    }

    String s = o2.orElse("데이터가 없음");
    System.out.println(s);
  }
}
