package chapter08;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
  public static void main(String[] args) {
    String s = "of, by, for the people";
    StringTokenizer st = new StringTokenizer(s); // ,delemeter(string),false
    System.out.println(st.countTokens());

    //일회성: 이터레이터, 이뉴머레이터
    StringTokenizer st1 = new StringTokenizer(s,",");
    System.out.println(st.countTokens());

    while(st.hasMoreTokens()){ //foreach같은것
      System.out.println(st.nextToken());
    }
  }
}
