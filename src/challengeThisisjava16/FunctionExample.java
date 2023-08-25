package challengeThisisjava16;

public class FunctionExample {
  public static double calc(FunctionEx fun) {
    double x = 10;
    double y = 4;
    return fun.apply(x, y);
  }
  public static void main(String[] args) {
    double result = calc( (x, y) -> (x / y) );
    System.out.println("result: " + result);
  }
}

@FunctionalInterface
interface FunctionEx {
  public double apply(double x, double y);
}