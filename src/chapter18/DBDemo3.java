package chapter18;

import java.sql.*;

public class DBDemo3 {
  public static void main(String[] args) throws SQLException{
    Connection conn = makeConnection();//conn 받아오기
    String sql = "insert into person (name, phone, email) values (?, ?, ?)";

    PreparedStatement preparedStatement = conn.prepareStatement(sql);
//    preparedStatement.setString(1, "김연아");
//    preparedStatement.setString(2, "015");
//    preparedStatement.setString(3, "kya@naver.com");
//
//    int i = preparedStatement.executeUpdate(); //db가 비어있지 않아서 쿼리 입력 X, 해커의 인젝션에 더 강함
//
//    if(i == 1) System.out.println("데이터 추가 성공");
//    else System.out.println("데이터 추가 실패");

    String sql1 = "update person set email = ? where phone = ?;";

    PreparedStatement ps = conn.prepareStatement(sql1);
    ps.setString(1, "pjs@naver.com");
    ps.setString(2, "010");


    boolean execute = ps.execute(); //변경여부
    if(!execute) System.out.println("수정 성공");
    else System.out.println("수정 실패");

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
