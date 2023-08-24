package chapter09;

import java.util.ArrayList;

public class GenericClass1Demo {
  public static void main(String[] args) {
    //제너릭 사용으로 타입 체크 안해도 됨, 런타임 에러 대신 컴파일 에러
    ArrayList<Boricha> arrayListBoricha = new ArrayList<>();
    arrayListBoricha.add(new Boricha());
//    arrayListBoricha.add(new Beer()); //컴파일 에러

    Cup c = new Cup();
    c.setBeverage(new Boricha());
    if(c.getBeverage() instanceof Boricha){
      Boricha boricha = (Boricha) c.getBeverage();
    } else if (c.getBeverage() instanceof Beer) {
      Beer beer = (Beer) c.getBeverage();
    }

    c.setBeverage(new Beer());
    Beer beer = (Beer) c.getBeverage();
//    Boricha beer = (Boricha) c.getBeverage(); //<T extends Beverage> - Boricha로 강제형변환후 Beer메서드 사용하면 익셉션
    c.setBeverage(new Beverage());
    c.setBeverage(new Object()); //<T extends Beverage> - 컴파일 에러
//    beer = (Beer) c.getBeverage(); //ClassCastException

    Cup<Boricha> borichaCup = new Cup<>();
    borichaCup.setBeverage(new Boricha());
//    borichaCup.setBeverage(new Beer()); //컴파일 에러
    Boricha boricha = borichaCup.getBeverage();
  }
}

class Beverage{}

class Boricha extends Beverage{}

class Beer extends Beverage{}

//class Cup{
//  private Object beverage;
//  public Object getBeverage(){
//    return beverage;
//  }
//  public void setBeverage(Object beverage){
//    this.beverage = beverage;
//  }
//}

class Cup<T>{ //<T extends Beverage>
  private T beverage;
  public T getBeverage(){
    return beverage;
  }
  public void setBeverage(T beverage){
    this.beverage = beverage;
  }
}