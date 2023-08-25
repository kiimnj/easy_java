package chapter10;

public class LambdaParameterDemo {
  public static void main(String[] args) {
    // 함수형 인터페이스를 매개변수로 사용하는 경우
    MyFunction f = (a, b) -> a > b ? a : b;
    myMethod(f); //5

    // 함수형 인터페이스를 리턴타입으로 사용하는 경우
    MyFunction myFunction = MyFunction2();
    System.out.println(myFunction.max(10,20)); //20
  }

  static void myMethod(MyFunction f) {
    System.out.println(f.max(3,5));
  }

  static MyFunction MyFunction2() {
    MyFunction f = (a, b) -> a > b ? a : b;
    return f;
  }
}

