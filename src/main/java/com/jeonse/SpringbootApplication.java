package com.jeonse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);

		/*try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306",
					"heejin",
					"test1234"
			);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"show databases"
			);

			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

}
