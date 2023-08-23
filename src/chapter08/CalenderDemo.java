package chapter08;

import java.util.Calendar;
import java.util.Date;

public class CalenderDemo {
  public static void main(String[] args) {
    Date now = new Date();
    System.out.println(now);

    //SUNDAY=1 ~. JANUARY=0  ~,MONTH=1 ~
    //static Calendar으로 정의
    Calendar c = Calendar.getInstance();
    System.out.println(c); //출력형태 보기 어려움
    System.out.println(c.get(Calendar.YEAR));
    System.out.println(c.get(Calendar.MONTH)+1);
    System.out.println(c.get(Calendar.DATE));
    System.out.println(c.getFirstDayOfWeek());

    Calendar c1 = Calendar.getInstance();
    System.out.println(c.compareTo(c1)); //-1: c1이 더 큼
  }
}
