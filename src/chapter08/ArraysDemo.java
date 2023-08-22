package chapter08;

import java.util.Arrays;

public class ArraysDemo {
  public static void main(String[] args) {
    char[] c1 = {'j', 'a', 'v', 'a'};
    char[] c2 = Arrays.copyOf(c1, c1.length); //그냥 문자열이 됨
    Character[] c3 = {'j', 'a', 'v', 'a'};
    print(c3);

    System.out.println(c1);
    System.out.println(c2);

    String[] s1 = {"A", "B", "C", "D"};
    int d = Arrays.binarySearch(s1, "D"); //index -> 3 - for문보다 효율적임
    for (String s : s1){
      if(s.equalsIgnoreCase("d")){ //for문
        System.out.println("찾았습니다.");
      }
      System.out.println(d);
      print(s1);
    }
  }
  static void print(Object[] objArray){
    for (Object obj : objArray) {
      System.out.print(obj);
      System.out.print(",");
    }
    System.out.println();
  }
}
