package chapter18;

import java.sql.*;

public class DBDemo5 {
  public static void main(String[] args) throws SQLException{
    Connection conn = makeConnection();//conn 받아오기
    String sql = "select * from person";

    PreparedStatement preparedStatement = conn.prepareStatement(sql);

    ResultSet rs = preparedStatement.executeQuery();

    while (rs.next()) { //boolean - 거꾸로 가는 메서드도 있음
      System.out.print("name : " + rs.getString(1) + ", ");
      System.out.print("phone : " + rs.getString("phone") + ", ");
      System.out.println("email : " + rs.getString(3));
    }

    conn.close(); //접속 끊기
    preparedStatement.close(); //나오기
  }

  static Connection makeConnection() {
    String url = "jdbc:mysql://127.0.0.1/sample?serverTimeZone=Asia/Seoul";

    Connection conn = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("DB 연결 중 ...");

      conn = DriverManager.getConnection(url, "root", "1111");
      System.out.println("DB 연결 성공!!");
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
