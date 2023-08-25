package chapter11;

import java.util.HashMap;
import java.util.Map;

public class HashMap1Demo {
  public static void main(String[] args) {
    Map<Fruit, Integer> fruits = new HashMap<>();
    System.out.println(fruits.size()); //0
    fruits.put(new Fruit("사과"), 10);
    fruits.put(new Fruit("바나나"), 5);
    fruits.put(new Fruit("딸기"), 3);
    System.out.println(fruits);

    fruits.put(new Fruit("사과"), 10); //수정이 아닌 추가
    System.out.println(fruits);

    fruits.put(null, 3); //HashTable은 NullPointerException, 그래서 더 많이 사용

  }
}

class Fruit {
  String name;
  public Fruit(String name){
    this.name = name;
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if(obj != null && obj instanceof Fruit fruit) {
      if (this.name.equals(fruit.name)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "[" + name + "]";
  }
}