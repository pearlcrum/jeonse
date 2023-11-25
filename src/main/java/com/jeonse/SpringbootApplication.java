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
					"jdbc:mysql://127.0.0.1:3306/happyhouse",
					"root",
					"carpediem3589@"
			);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select * from housedeal"
			);

			while (rs.next()) {
				for(int i=1;i<9;i++){
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

	}

}
