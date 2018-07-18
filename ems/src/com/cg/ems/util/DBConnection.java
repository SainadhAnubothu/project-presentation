package com.cg.ems.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.ems.exception.EmployeeMaintenanceException;

public class DBConnection {
	private static Connection conn=null;
	public static Connection getConnection() throws EmployeeMaintenanceException{
		if(conn==null){
			try {
				FileInputStream fin = new FileInputStream("resources/JDBC.properties");
				Properties props = new Properties();
				props.load(fin);			
				String driver = props.getProperty("db.driver");
				String url = props.getProperty("db.url");
				String user = props.getProperty("db.user");
				String pass = props.getProperty("db.pass");
				conn=DriverManager.getConnection(url, user, pass);
				conn.commit();
			}catch (FileNotFoundException e) {
				throw new EmployeeMaintenanceException("Property file not found.."+e.getMessage());
			} catch (IOException e) {
				throw new EmployeeMaintenanceException("Problem in reading property.."+e.getMessage());
			} catch (SQLException e) {
				throw new EmployeeMaintenanceException("Problem in obtaining connection.."+e.getMessage());
			}

			
		}
		return conn;
	}

}
