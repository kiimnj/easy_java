package chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemo2 {
  public static void main(String[] args) throws SQLException{
    Connection conn = makeConnection();//conn 받아오기
    Statement statement = conn.createStatement();
    String sql = "insert into person (name, phone, email) values ('김연아', '012', 'kya@naver.com')";
    int i = statement.executeUpdate(sql); //비어있는 상태라서 sql 넘겨줌

    if(i == 1) System.out.println("데이터 추가 성공");
    else System.out.println("데이터 추가 실패");

    conn.close(); //접속 끊기
    statement.close(); //나오기
  }

  static Connection makeConnection() {
    String url = "jdbc:mysql://127.0.0.1/sample?serverTimeZone=Asia/Seoul";

    Connection conn = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("DB 연결 중 ...");

      conn = DriverManager.getConnection(url, "root", "1111");
      System.out.println("DB 연결 성공!!");
//      conn.close(); //주석 풀면 접속 끊겨서 에러
    } catch (ClassNotFoundException e) {
//      throw new RuntimeException(e);
      System.out.println("JDBC driver 찾지 못함");
    } catch (SQLException e) {
//      throw new RuntimeException(e);
      System.out.println("DB 연결 실패");
    }
    System.out.println("프로그램 종료");

    return conn;
  }
}
