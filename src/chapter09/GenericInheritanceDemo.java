package chapter09;

import java.util.ArrayList;

public class GenericInheritanceDemo {
  public static void main(String[] args) {
    ArrayList<Beer> a1 = new ArrayList<>();
    ArrayList<Boricha> a2 = new ArrayList<>();
    ArrayList<Beverage> a3 = new ArrayList<>();

    //a3는 다 add 가능
    a3.add(new Beverage());
    a3.add(new Beer());
    a3.add(new Boricha());

    Beer beverage = (Beer) a3.get(1);
    System.out.println(beverageTest(a3));

//    beverageTest(a2); //원소간의 상속관계가 어레이리스트까지 이어지진 X
  }
  static boolean beverageTest(ArrayList<Beverage> array){
    return true;
  }
}

