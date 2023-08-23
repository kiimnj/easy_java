package chapter08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
  public static void main(String[] args) {
//    Date date = new Date();
    Date date = new Date(2023,11,31);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println(sdf.format(date));
  }
}
