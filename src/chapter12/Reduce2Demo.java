package chapter12;

public class Reduce2Demo {
  public static void main(String[] args) {
    Nation.nations.stream()
        .reduce((x, y) -> x.getPopulation() > x.getPopulation() ? x : y)
        .ifPresent(System.out::println);
  }
}
