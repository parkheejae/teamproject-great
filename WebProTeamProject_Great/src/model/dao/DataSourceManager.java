package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataSourceManager {
	private DataSource ds;//수정
	
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		//원래는 여기서 Naming Service가 진행됨....
		 try {
			Context ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource Lookup.....");
		 }catch(Exception e) {
			 System.out.println("DataSource Lookup.....Fail....");
		 }
	}
	
	public static DataSourceManager getInstance() {
		return instance;
	}

	public DataSource getConnection(){
		return ds;
	}
}








