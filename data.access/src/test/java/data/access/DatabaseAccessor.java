package data.access;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DatabaseAccessor {
	String[] ExecuteSingleColumn(String sql) throws SQLException;
	
	String ExecuteSingleCell(String sql, String key) throws SQLException;
		
	List<String[]> Execute(String sql) throws SQLException;
	
	String[] ExecuteStoredProcedure(String sql) throws SQLException; 
	
	List<HashMap<String,Object>> convertResultSetToList(ResultSet rs) throws SQLException;

	ArrayList<String> parseMapList(List<HashMap<String,Object>> result);

	
}
