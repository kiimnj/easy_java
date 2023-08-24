package chapter11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
  public static void main(String[] args) {
    Collection<String> list = Arrays.asList("다람쥐", "개구리", "나비"); //new Collection<>불가

    //컨+알트+v - 자동완성
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()){ //일회성 루프
      System.out.println(iterator.next() + "-");
    }
    System.out.println();

    iterator = list.iterator();
    while (iterator.hasNext()){
      System.out.println(iterator.next() + "-");
    }
    System.out.println();
  }
}
