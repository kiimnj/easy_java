package chapter08;

import java.util.Random;

public class DiceRandomDemo {
  public static void main(String[] args) {
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
      System.out.println("주사위 숫자는 " + (r.nextInt(6) + 1));
//      System.out.println("주사위 숫자는 " + r.nextInt(1,7));
    }
  }
}
