package chapter08;

import java.util.Calendar;

public class CalenderTest {
  public static void main(String[] args) {
    String[] weekName = {"일", "월", "화", "수", "목", "금", "토"};
    String[] noonName = {"오전", "오후"};
    Calendar c = Calendar.getInstance();


//    int year = c.get(Calendar.YEAR);
    int year = c.get(c.YEAR);
    int month = c.get(c.MONTH) +1;
//    int day = c.get(Calendar.DAY_OF_MONTH);
    int day = c.get(c.DATE);

    String week = weekName[c.get(c.DAY_OF_WEEK) - 1];
    String noon = noonName[c.get(c.AM_PM)]; //값 모르면 확인해보기

    int hour = c.get(c.HOUR);
//    int hour = c.get(Calendar.HOUR_OF_DAY);
    int minute = c.get(c.MINUTE);
    int second = c.get(c.SECOND);

    System.out.println(year + "년" + month + "월" + day + "일");
    System.out.println(week + "요일" + noon);
    System.out.println(hour + "시" + minute + "분" + second + "초");
  }
}

