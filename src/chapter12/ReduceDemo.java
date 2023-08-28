package chapter12;

import java.util.List;

public class ReduceDemo {
  public static void main(String[] args) {
    List<Integer> list = List.of(3,4,5,1,2);
//    Integer i = list.stream().reduce((x, y) -> x + y).get();
    int i = list.stream().reduce((x, y) -> x + y).get(); //오토언박싱 - 기본형도 가능

    int i1 = list.stream().reduce(0, (x, y) -> x + y); //초기값 주면 .get()안해도 됨

    int i2 = list.stream().reduce(1, (x, y) -> x * y); //*이므로 초기값 1
    System.out.println(i2);
  }
}
