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
	
	private String connectionString;

	public DatabaseUtility(String connectionString) {
		this.connectionString = connectionString;
	}

	public String[] ExecuteSingleColumn(String sql) throws SQLException {
		 
		Connection connection = null;
		connection = connectToDatabase();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
			
		//Store data in Collection so resultSet can be closed
		List<HashMap<String,Object>> result = convertResultSetToList(resultSet);

		resultSet.close();
		statement.close();
		connection.close();
		
		ArrayList<String> resultArray = parseMapList(result);
		
		return resultArray.toArray(String[]::new);
	}

	public String ExecuteSingleCell(String sql, String key) throws SQLException {
		Connection connection = null;
		connection = connectToDatabase();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		String result = null;
		while(resultSet.next()) {
			result = resultSet.getString(key).toString();
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
		return result;
	}

	public List<String[]> Execute(String sql) throws SQLException {
		Connection connection = null;
		connection = connectToDatabase();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		//get column count
		ResultSetMetaData rsMetaData = resultSet.getMetaData();
		int cols = rsMetaData.getColumnCount();
		
		List<String[]> output = new ArrayList<String[]>();
		String[] colNames = this.GetColumns(resultSet);
		output.add(colNames);
		
		//populate datarow with string[] (records/rows)
		while(resultSet.next()) {
			String[] row = new String[cols];
			for(int i = 0; i < cols; i++) 
			{
				row[i] = resultSet.getString(colNames[i]);
			}
			output.add(row);
		}
		resultSet.close();
		statement.close();
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
	
	public String[] ExecuteStoredProcedure(String sql) throws SQLException{
		Connection connection = null;
		connection = connectToDatabase();
		CallableStatement statement = connection.prepareCall(sql);
		
		//register parameters
		statement.registerOutParameter(3, Types.INTEGER);
		
		ResultSet resultSet = statement.executeQuery();
		
		//Store data in Collection so resultSet can be closed
		List<HashMap<String,Object>> result = convertResultSetToList(resultSet);

		resultSet.close();
		statement.close();
		connection.close();
				
		ArrayList<String> resultArray = parseMapList(result);
				
		return resultArray.toArray(String[]::new);
		
	}
	
	public List<HashMap<String,Object>> convertResultSetToList(ResultSet rs) throws SQLException {
	    ResultSetMetaData metaData = rs.getMetaData();
	    int columns = metaData.getColumnCount();
	    List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();

	    while (rs.next()) {
	        HashMap<String,Object> row = new HashMap<String, Object>(columns);
	        for(int i=1; i<=columns; ++i) {
	            row.put(metaData.getColumnName(i),rs.getObject(i));
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
			HashMap<String, Object> hashMap =  (HashMap<String, Object>) it.next();
			for (Object obj : hashMap.keySet()) {
				ar.add( hashMap.get(obj).toString());
			}
		}
		
		return ar;
	}

	private Connection connectToDatabase() throws SQLException {
		return DriverManager.getConnection(this.connectionString);
	}
	
}
