package chapter11;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
  public static void main(String[] args) {
    //db축소판(?)
    Map<String, Integer> fruits = Map.of("사과",5, "바나나",3, "딸기",10, "배",1);
    Map<String, Integer> hashFruits = new HashMap<>(fruits);

    hashFruits.put("키위",10);
    System.out.println(hashFruits); //Map,HashMap 둘 다 key가 set으로 구현 - 입력 순서 무시

    hashFruits.put("키위",1); //변경
    System.out.println(hashFruits);

    hashFruits.remove("키위");
    System.out.println(hashFruits);

    hashFruits.clear();
    System.out.println(hashFruits.size());
    System.out.println(hashFruits.isEmpty());
  }
}
