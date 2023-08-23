package chapter09;

import java.util.Arrays;

public class GenericMethodDemo {
  public static void main(String[] args) {
    Integer[] ia = { 1, 2, 3, 4, 5 };
    Character[] ca = { 'a', 'b', 'c', 'd', 'e' };

    Box[] ba = {new Box(), new Box()};
    ba[0].set(10);
    ba[1].set(20);

    Utils.showArray(ia); //[1, 2, 3, 4, 5]
    Utils.showArray(ca); //[a, b, c, d, e]

//    System.out.println(Utils.getLast(ia)); //5
//    System.out.println(Utils.getLast(ca)); //e
  }
}

class Utils{
  static <T> void showArray(T[] array){
//  static void showArray(Integer[] array){ //static - 메서드 사용시 인스턴스 객체 생성 안했음
    for( T t : array) {
      System.out.printf("%s ", t);
    }
    System.out.println();
  }

  //타입마다 정의하는건 solid(ocp) 원칙에 어긋남
//  static void showArray(Character[] array){
//    System.out.println(Arrays.toString(array));
//  }

  static <T> T getLast(T[] array) {return array[array.length - 1];}

}