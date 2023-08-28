package chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StreamDemo {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
      list.add(r.nextInt(30)); //저장공간 10개
    }

    List<Integer> gt10 = new ArrayList<>();
    for (Integer i : list) {
      if(i > 10) gt10.add(i); //저장공간 10개
    }

    Collections.sort(gt10);
    System.out.println(gt10);
    System.out.println();

    //스트림 - 결과가 스트림이면 스트림 연산 체이닝 가능
    list.stream()
        .filter(i -> i>10)
        .sorted()
        .forEach( x -> System.out.print(x + " "));
  }
}
