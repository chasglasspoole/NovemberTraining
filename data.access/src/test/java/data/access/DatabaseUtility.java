package data.access;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class DatabaseUtility implements DatabaseAccessor, DataRow {

	public ArrayList<String> ExecuteSingleColumn(String sql) throws SQLException {
		 
		// Establishing a Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?allowPublicKeyRetrieval=true&useSSL=false", "root", "P@ssw0rd");
		// create statement
		Statement stmt = connection.createStatement();
		//execute query
		ResultSet rs = stmt.executeQuery(sql);
			
		//Store data in Collection so resultSet can be closed
		List<HashMap<String,Object>> result = convertResultSetToList(rs);

		rs.close();
		stmt.close();
		connection.close();
		
		ArrayList<String> resultArray = parseMapList(result);
		
		return resultArray;
	}

	public String ExecuteSingleCell(String sql, String key) throws SQLException {
		// Establishing a Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?allowPublicKeyRetrieval=true&useSSL=false", "root", "P@ssw0rd");
		// create statement
		Statement stmt = connection.createStatement();
		//execute query
		ResultSet rs = stmt.executeQuery(sql);
		
		String result = null;
		while(rs.next()) {
			result = rs.getString(key).toString();
		}
		
		rs.close();
		stmt.close();
		connection.close();
		
		return result;
	}

	public List<String[]> Execute(String sql) throws SQLException {
		// Establishing a Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?allowPublicKeyRetrieval=true&useSSL=false", "root", "P@ssw0rd");
		// create statement
		Statement stmt = connection.createStatement();
		//execute query
		ResultSet rs = stmt.executeQuery(sql);
		
		//get column count
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int cols = rsMetaData.getColumnCount();
		
		List<String[]> output = new ArrayList<String[]>();
		String[] colNames = this.GetColumns(rs);
		output.add(colNames);
		
		//populate datarow with string[] (records/rows)
		while(rs.next()) {
			String[] row = new String[cols];
			for(int i = 0; i < cols; i++) 
			{
				row[i] = rs.getString(colNames[i]);
			}
			output.add(row);
		}
		rs.close();
		stmt.close();
		connection.close();
		
		return output;
	}
	
	@Override
	public String[] GetColumns(ResultSet rs) throws SQLException {
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int cols = rsMetaData.getColumnCount();
		
		String[] colNames = new String[cols];
		
		for(int i = 0; i < cols; i++) {
			colNames[i] = rsMetaData.getColumnName(i+1);
		}
		return colNames;
	}
	
	public ArrayList<String> ExecuteStoredProcedure(String sql, int p) throws SQLException{
		// Establishing a Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?allowPublicKeyRetrieval=true&useSSL=false", "root", "P@ssw0rd");
		// create statement
		CallableStatement stmt = connection.prepareCall(sql);
		
		//register parameters
		stmt.setInt(1, p);
		stmt.setInt(2,2);
		stmt.registerOutParameter(3, Types.INTEGER);
		
		//execute query
		ResultSet rs = stmt.executeQuery();
		
		//Store data in Collection so resultSet can be closed
		List<HashMap<String,Object>> result = convertResultSetToList(rs);

		rs.close();
		stmt.close();
		connection.close();
				
		ArrayList<String> resultArray = parseMapList(result);
				
		return resultArray;
		
	}
	
	public List<HashMap<String,Object>> convertResultSetToList(ResultSet rs) throws SQLException {
	    ResultSetMetaData md = rs.getMetaData();
	    int columns = md.getColumnCount();
	    List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();

	    while (rs.next()) {
	        HashMap<String,Object> row = new HashMap<String, Object>(columns);
	        for(int i=1; i<=columns; ++i) {
	            row.put(md.getColumnName(i),rs.getObject(i));
	        }
	        list.add(row);
	    }

	    return list;
	}
	
	public ArrayList<String> parseMapList(List<HashMap<String,Object>> result){
		Iterator it = result.iterator();
		ArrayList<String> ar = new ArrayList<String>();
		
		//iterate through list of hash map objects then cast to string and add to array list
		while(it.hasNext()) {
			HashMap<String, Object> hm =  (HashMap<String, Object>) it.next();
			for (Object obj : hm.keySet()) {
				ar.add( hm.get(obj).toString());
			}
		}
		
		return ar;
	}

	
}



