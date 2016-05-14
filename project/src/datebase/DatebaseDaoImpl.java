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

	// �����ڿ��� DB�� �����ϱ�
	public DatebaseDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("����̹��ε�����!");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			// 127.0.0.1 : ����  �����Ƿ� �ڽ��� ��ǻ�ͷ� �ٽ� ���ư���.
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("db���� ����!!!");
			// sql ������ �����ϴ� ��ü ������
			stmt = con.createStatement();
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
