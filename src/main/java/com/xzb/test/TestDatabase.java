package com.xzb.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestDatabase {

	public static void main(String args[]) {
		// 准备分类测试数据：

		//test("insert into category values (null, '测试分类%d')");
       // test("insert into lost values(null,'名称','20190202','罗振兴','广师大','%d' )");
        test("insert into user values(null,'用户名%d','密码')");
	}

	private static void test(String sqlFormat) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/losefind?useUnicode=true&characterEncoding=utf8", "root", "941128");
				Statement s = c.createStatement();) {
			for (int i = 1; i <= 10; i++) {
				String sql = String.format(sqlFormat, i);
				s.execute(sql);
			}

			System.out.println("已经成功创建10条分类测试数据");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
