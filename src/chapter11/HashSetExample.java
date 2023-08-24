package chapter11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
  public static void main(String[] args) {
    Set<Person> set = new HashSet<>();
    Iterator<Person> iterator = set.iterator();

    set.add(new Person("김열공", 20));
    set.add(new Person("최고봉", 56));
    set.add(new Person("우등생", 16));
    set.add(new Person("나자바", 35));

    //두 해시코드가 다르게 나옴 - 다른 객체라서 다른 해시셋 취급
    System.out.println(new Person("나자바", 35).hashCode());
    System.out.println(new Person("나자바", 35).hashCode());

    while (iterator.hasNext()){
      System.out.print(iterator.next() + ", "); //set은 순서 무시하고 저장, 출력
    }
    System.out.println();

    //동일한 객체 추가 테스트
    set.add(new Person("나자바", 35));
    iterator = set.iterator();
    while (iterator.hasNext()){
      System.out.print(iterator.next() + ", ");
    }
    System.out.println();

  }
}

class Person{
  String name;
  int age;
  public Person(String name, int age){
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person[" + name + " : " + age + "]";
  }

  @Override
  public int hashCode() {
    return name.hashCode() + age;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj != null && obj instanceof Person person) {
      if (this.hashCode() == person.hashCode()) {
        return true;
      }
    }
    return false;
  }
}