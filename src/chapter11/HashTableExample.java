package chapter11;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExample {
  public static void main(String[] args) {
    Map<String, Integer> map = new Hashtable<>();

    map.put("김열공", 20);
    map.put("최고봉", 56);
    map.put("우등생", 16);
    map.put("나자바", 35);

    String name = "";
    Scanner in = new Scanner(System.in);
    while(true) {
      System.out.print("이름을" + " 입력하세요. 종료하려면 엔터 : ");
      name = in.nextLine();
      if(name.isBlank()) break;
      if (map.get(name) != null)
        System.out.println(name + "의 점수는 " + map.get(name) + "입니다.");
      else
        System.out.println(name + "의 점수는 존재하지 않습니다.");
    }
  }
}
