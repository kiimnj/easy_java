package chapter12;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class OptionalDemo {
  public static OptionalDouble divide(double x, double y) {
    return (y == 0) ? OptionalDouble.empty() : OptionalDouble.of(x / y);
//    return OptionalDouble.of(x / y); //OptionalDouble[Infinity]
  }

  public static OptionalInt divide(int x, int y) { //오버로딩
    return (y == 0) ? OptionalInt.empty() : OptionalInt.of(x / y);
//    return OptionalDouble.of(x / y); //OptionalDouble[Infinity]
  }

  public static void main(String[] args) {
    OptionalDouble divide = divide(10.0, 2.0);
    System.out.println(divide); //OptionalDouble[5.0]
    System.out.println(divide.getAsDouble()); //5.0
    System.out.println(10.0 / 0.0); //Infinity

    OptionalInt divideInt = divide(10, 2);
    System.out.println(divideInt); //OptionalInt[5]
    System.out.println(divideInt.getAsInt()); //5

    OptionalDouble divideZero = divide(10.0, 0.0);
    System.out.println(divideZero); //OptionalDouble.empty
//    System.out.println(divideZero.getAsDouble()); //NoSuchElementException

    Optional<String> apple = Optional.of("apple");
    System.out.println(apple);
    System.out.println(apple.get());
  }
}
