package chapter09;

public class GenericMethod2Demo {
  public static void main(String[] args) {
    Integer[] ia = { 1, 2, 3, 4, 5 };
    Double[] da = { 1.0, 2.0, 3.0, 4.0, 5.0 };
    Character[] ca = { 'a', 'b', 'c', 'd', 'e' };

    Utils.showArray(ia); //[1, 2, 3, 4, 5]
    Utils.showArray(da); //[1.0, 2.0, 3.0, 4.0, 5.0]
    Utils.showArray(ca); //[a, b, c, d, e]

//    System.out.println(Utils.getLast(ia)); //5
//    System.out.println(Utils.getLast(da)); //5.0
//    System.out.println(Utils.getLast(ca)); //e
  }
}

class Utils2{
  static <T extends Number> void showArray(T[] array){ //extends반대로 super도 가능
    for( T t : array) {
      System.out.printf("%s ", t);
    }
    System.out.println();
  }

  static <T> T getLast(T[] array) {return array[array.length - 1];}

}