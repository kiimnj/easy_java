package chapter10;

public class FunctionalInterfaceDemo {
  public static void main(String[] args) {
//    MyFunction f = new MyFunction() {
//      @Override
//      public int max(int a, int b) {
//        return a > b ? a : b;
//      }
//    };
    MyFunction f = (a, b) -> a > b ? a : b;

    int max = f.max(4,6);
    System.out.println(max);
  }
}

@FunctionalInterface
interface MyFunction {
  int max(int a, int b);
//  int min(int a, int b);
}