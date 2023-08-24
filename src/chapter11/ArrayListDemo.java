package chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
  public static void main(String[] args) {
    //ListDemo와의 차이점
    List<String> cars = List.of("소나타","아반테","캐스퍼","모닝");
    List<String> list = new ArrayList<>(cars);
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()){
      System.out.print(iterator.next() + ",");
    }
    System.out.println();

    list.add("소울"); //이전엔 add 안됐었음
    for (String car : list){
      System.out.print(car + ":");
    }
    System.out.println();

    list.set(4,"제네시스");
    System.out.println(list);

    list.remove(4);
    list.remove(list.get(0));
    list.remove("아반테");
    System.out.println(list);
    System.out.println(list.size());
  }
}
