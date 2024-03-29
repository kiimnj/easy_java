package chapter08;

public class PersonTest {
  public static void main(String[] args) {
    Person p1 = new Person("111111", "홍길동");
    Person p2 = new Person("111111", "손흥민");

    if (p1.equals(p2)) System.out.println("같은 사람이다.");
    else System.out.println("다른 사람이다.");
  }
}

class Person{
  String id, name;
  public Person(String id,String name){
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Person person){
      if (person != null && this.id.equals(person.id)){
        return true;
      }
    }
    return false;
  }
}