package chapter08;

public class CircleTest {
  public static void main(String[] args) {
    Circle c1 = new Circle(3);
    Circle c2 = new Circle(3);

    if (c1.equals(c2)) System.out.println("c1과 c2는 같다.");
    else System.out.println("c1과 c2는 다르다.");
  }
}

class Circle{
  int radius;
  public Circle(int radius){ this.radius = radius; }

//  private int radius;
//  public int getRadius(){
//    return radius;
//  }
//
//  public void setRadius(int radius){
//    this.radius = radius;
//  }

  //오버라이딩
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Circle circle){ //circle:다운캐스팅
      if(circle != null && this.radius == circle.radius){
        return true;
      }
    }
    return false;
  }

//  //오버로딩으로 풀기
//  public boolean equals(Circle circle){
//    if(this.radius == circle.radius){
//      return true;
//    }
//    return false;
//  }
}