package datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatebaseDaoImpl {

	private Connection con;
	private Statement stmt;
	private Scanner scan = new Scanner(System.in);

	// 생성자에서 DB에 접속하기
	public DatebaseDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버로딩성공!");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			// 127.0.0.1 : 루프  아이피로 자신의 컴퓨터로 다시 돌아간다.
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("db접속 성공!!!");
			// sql 구문을 실행하는 객체 얻어오기
			stmt = con.createStatement();
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
