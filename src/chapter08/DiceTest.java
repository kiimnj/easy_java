package chapter08;


public class DiceTest {
  public static void main(String[] args) {
    System.out.println(new Dice().roll());
  }
}

class Dice{

  int roll(){
    return ((int)(Math.random()) * 6) + 1;
  }
}