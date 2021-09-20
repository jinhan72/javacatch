package model.common;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JNDI {
	
	public static Connection getConnection() {
		Connection conn;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			conn = ds.getConnection();
		}
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
		return conn;
	}
}
