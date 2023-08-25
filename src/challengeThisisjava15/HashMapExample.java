package challengeThisisjava15;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
  public static void main(String[] args) {
    Map<String, String> animals = Map.of("호랑이","tiger", "표범","leopard", "사자","lion");
    HashMap<String, String> map = new HashMap<>(animals);
    System.out.println(map);

    map.replaceAll((k ,v) -> v.toUpperCase());
    System.out.println(map);
  }
}
