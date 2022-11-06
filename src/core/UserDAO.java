package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import org.json.simple.*;

import util.ConnectionPool;

public class UserDAO {
	public boolean insert(String uid, String upass, String uname) throws NamingException, SQLException {
		Connection conn = ConnectionPool.get();
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO user(id, password, name) VALUES(?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			stmt.setString(2, upass);
			stmt.setString(3, uname);
	
			int count = stmt.executeUpdate();
			return (count == 1) ? true : false;
			
		} finally {
			if (stmt != null) stmt.close(); 
			if (conn != null) conn.close();
		}
	}

	public boolean exists(String uid) throws NamingException, SQLException {
		Connection conn = ConnectionPool.get();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id FROM user WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
	
			rs = stmt.executeQuery();
			return rs.next();
			
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close(); 
			if (conn != null) conn.close();
		}
	}

	public boolean delete(String uid) throws NamingException, SQLException {
		Connection conn = ConnectionPool.get();
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM user WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
	
			int count = stmt.executeUpdate();
			return (count == 1) ? true : false;
			
		} finally {
			if (stmt != null) stmt.close(); 
			if (conn != null) conn.close();
		}
	}

	public int login(String uid, String upass) throws NamingException, SQLException {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	        String sql = "SELECT id, password FROM user WHERE id = ?";

	        conn = ConnectionPool.get();
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, uid);

	        rs = stmt.executeQuery();
	        if (!rs.next()) return 1;
	        if (!upass.equals(rs.getString("password"))) return 2;
	        return 0;
	        
	    } finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close(); 
			if (conn != null) conn.close();
	    }
	}	

	public String Perfume_getList() throws NamingException, SQLException {
		Connection conn = ConnectionPool.get();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
		    String sql = "SELECT * FROM perfume ORDER BY no ASC";
		    stmt = conn.prepareStatement(sql);
		    rs = stmt.executeQuery();
		    /*
		    ArrayList<UserObj> users = new ArrayList<UserObj>();
	        while(rs.next()) {
	        	users.add(new UserObj(rs.getString("id"), rs.getString("name"), rs.getString("ts")));
	        	*/
		    
		    JSONArray users = new JSONArray();
		    while(rs.next())
		    {
		    	JSONObject UserObj = new JSONObject();
		    	UserObj.put("no", rs.getString("no"));
		    	UserObj.put("perfume_name", rs.getString("perfume_name"));
		    	UserObj.put("perfume_image", rs.getString("perfume_image"));
		    	UserObj.put("perfume_ingredient", rs.getString("perfume_ingredient"));
		    	UserObj.put("perfume_content", rs.getString("perfume_content"));
		    	users.add(UserObj);
	        }
		    return users.toJSONString();
			
		} finally {
			if (rs != null) rs.close(); 
			if (stmt != null) stmt.close(); 
			if (conn != null) conn.close();
		}
	}

	public String Ingre_getList() throws NamingException, SQLException {
		Connection conn = ConnectionPool.get();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
		    String sql = "SELECT * FROM ingredient ORDER BY no ASC";
		    stmt = conn.prepareStatement(sql);
		    rs = stmt.executeQuery();
		    
		    JSONArray users = new JSONArray();
		    while(rs.next())
		    {
		    	JSONObject UserObj = new JSONObject();
		    	UserObj.put("no", rs.getString("no"));
		    	UserObj.put("ingredient_name", rs.getString("ingredient_name"));
		    	UserObj.put("ingredient_image", rs.getString("ingredient_image"));
		    	UserObj.put("perfume_include", rs.getString("perfume_include"));
		    	UserObj.put("ingredient_content", rs.getString("ingredient_content"));
		    	users.add(UserObj);
	        }
		    return users.toJSONString();
			
		} finally {
			if (rs != null) rs.close(); 
			if (stmt != null) stmt.close(); 
			if (conn != null) conn.close();
		}
	}
}
