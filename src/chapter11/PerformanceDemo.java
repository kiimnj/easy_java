package chapter11;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceDemo {
  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<>();
    LinkedList<Integer> ll = new LinkedList<>();

    //ArrayList 값 추가
    //맨앞
    long start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.add(i);
    }
    long end = System.nanoTime();
    long arrayList = end - start;
    System.out.println(arrayList);

    //맨뒤
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.add(0, i);
    }
    end = System.nanoTime();
    arrayList = end - start;
    System.out.println(arrayList); //Array 성질 - 오래걸림

    //ArrayList 값 삭제
    //맨앞
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.remove(0);
    }
    end = System.nanoTime();
    arrayList = end - start;
    System.out.println(arrayList); //Array 성질 - 오래걸림

    //맨뒤
    for (int i = 0; i < 100_000; i++) {
      al.add(0, i);
    }
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      al.remove(al.size() -1);
    }
    end = System.nanoTime();
    arrayList = end - start;
    System.out.println(arrayList);

    //LinkedList 값 추가
    //맨앞
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.add(i);
    }
    end = System.nanoTime();
    long linkedList = end - start;
    System.out.println(linkedList);

    //맨뒤
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.add(0, i);
    }
    end = System.nanoTime();
    linkedList = end - start;
    System.out.println(linkedList); //(얜 중간에 넣으면 오래걸리나..)

    //LinkedList 값 삭제
    //맨앞
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.removeFirst();
    }
    end = System.nanoTime();
    linkedList = end - start;
    System.out.println(linkedList);

    //맨뒤
    for (int i = 0; i < 100_000; i++) {
      ll.add(i);
    }
    start = System.nanoTime();
    for (int i = 0; i < 100_000; i++) {
      ll.removeLast();
    }
    end = System.nanoTime();
    linkedList = end - start;
    System.out.println(linkedList);
  }
}
