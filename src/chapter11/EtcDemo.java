package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class EtcDemo {
  public static void main(String[] args) {
    List<String> list1 = List.of("A","A","A","B","B","C","D","E");
    HashSet<String> set = new HashSet<>(list1);
    List<String> list2 = new ArrayList<>(list1);

    System.out.println(set.size());
    System.out.println(list2.size());
    System.out.printf("list2에는 A가 %d번 들어가 있음\n", Collections.frequency(list2,"A"));
    System.out.printf("list2의 가장 큰 글자는 %s임", Collections.max(list2));
  }
}
