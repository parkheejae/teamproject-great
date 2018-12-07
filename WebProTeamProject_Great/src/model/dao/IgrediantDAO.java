package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class IgrediantDAO {
DataSource ds;
	
	private static IgrediantDAO dao= IgrediantDAO();
	
	private IgrediantDAO() {
		ds=DataSourceManager.getInstance().getConnection();
	}
	
	public static IgrediantDAO IgrediantDAO() {
		
		return dao;
	}
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
}
