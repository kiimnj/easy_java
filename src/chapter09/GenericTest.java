package chapter09;

import java.util.ArrayList;

public class GenericTest {
  public static void main(String[] args) {
    ArrayList nums = new ArrayList(); //<>로 타입지정 안할경우 Object로 들어감
//    ArrayList<Integer> nums = new ArrayList(); //Integer임이 보장됨
    nums.add(10); //인티저로 오토언박싱
    nums.add(3.14); //더블로 오토언박싱, <Integer> 지정할 경우 컴파일 에러
    nums.add("hello"); //<Integer> 지정할 경우 컴파일 에러

    //하나하나 예외 예상해서 코딩해줘야 - 솔리드 원칙 위반
    for (int i = 0; i < nums.size(); i++) {
      if(nums.get(i) instanceof Integer){
        System.out.println(((Integer)nums.get(i)) * 2); //배열이 아니므로 foreach불가
      } else if (nums.get(i) instanceof Double){ //<Integer> 지정할 경우 컴파일 에러
        System.out.println(((Double)nums.get(i)) * 2); //<Integer> 지정할 경우 컴파일 에러
      } else System.out.println("숫자 타입이 아닙니다.");
    }

    String s = "world";
    ArrayList<String> strs = new ArrayList<>();
    strs.add("hello");
    strs.add(s);
    strs.add("");
    strs.add(null);

    for (int i = 0; i < strs.size(); i++) {
      String getStr = strs.get(i);
      if(getStr != null){
        System.out.println();
      }
    }

  }
}
