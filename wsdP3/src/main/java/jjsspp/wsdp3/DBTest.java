package jjsspp.wsdp3;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {
	public static void main(String[] args) {
		// applicationContext.xml에 적은 정보 그대로 복사
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://walab.handong.edu:3306/W25_22200182";
		String uid = "W25_22200182";
		String upw = "jooPh7"; // 여기에 실제 비밀번호 넣으세요

		try {
			Class.forName(driver);
			System.out.println("1. 드라이버 로딩 성공!");

			Connection con = DriverManager.getConnection(url, uid, upw);
			System.out.println("2. DB 연결 성공! (객체: " + con + ")");

			con.close();
			System.out.println("3. 연결 해제 완료.");

		} catch (Exception e) {
			System.out.println("!!! 연결 실패 !!!");
			e.printStackTrace();
		}
	}
}