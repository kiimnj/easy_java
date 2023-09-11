package chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
  static Connection makeConnection() {
    String url = "jdbc:mysql://127.0.0.1/madang?serverTimeZone=Asia/Seoul";

    Connection conn = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("DB 연결 중 ...");

      conn = DriverManager.getConnection(url, "root", "1111");
      System.out.println("DB 연결 성공!!");
    } catch (ClassNotFoundException e) {
      System.out.println("JDBC driver 찾지 못함");
    } catch (SQLException e) {
      System.out.println("DB 연결 실패");
    }
//    System.out.println("프로그램 종료");

    return conn;
  }
}
