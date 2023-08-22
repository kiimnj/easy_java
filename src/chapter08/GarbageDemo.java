package chapter08;

public class GarbageDemo {
  public static void main(String[] args) {
    for (int i = 0; i < 4; i++) {
      new Garbage(i);
      System.gc();
    }
  }
}

class Garbage{
  int no;
  public Garbage(int no){
    this.no = no;
    System.out.println("Garbage(" + no + ")가 생성됨");
  }

  @Override //사실상 자바가 알아서 해줘서 쓸모는 없음, 생성 수거 시간차 일정하지 않을 수 있음
  protected void finalize() throws Throwable {
    System.out.println("Garbage(" + no + ")가 수거됨");

  }
}