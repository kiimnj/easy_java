package chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDemo1 {
  public static void main(String[] args) {
    String url = "jdbc:mysql://127.0.0.1/sample?serverTimeZone=Asia/Seoul";

    Connection conn = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 없거나 그럴 수 있으므로
      System.out.println("DB 연결 중 ..."); //위 문장 성공 시 실행

      conn = DriverManager.getConnection(url, "root", "1111");
      System.out.println("DB 연결 성공!!"); //위 문장 성공 시 실행
      conn.close();
    } catch (ClassNotFoundException e) { //SQLException??ClassNotFoundException
//      throw new RuntimeException(e);
      System.out.println("JDBC driver 찾지 못함");
    } catch (SQLException e) {
//      throw new RuntimeException(e);
      System.out.println("DB 연결 실패");
    }
    System.out.println("프로그램 종료");
  }
}
