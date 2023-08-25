package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleDemo {
  public static void main(String[] args) {
    List<Character> list = new ArrayList<>();
    for (char c = 'A'; c < 'G'; c++) {
      list.add(c);
    }
    System.out.println(list);

    Collections.rotate(list, 3);
    System.out.println(list);

    Collections.shuffle(list);
    System.out.println(list);
  }
}
