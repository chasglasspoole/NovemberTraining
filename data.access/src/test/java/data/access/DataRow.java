package data.access;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataRow {
	String[] GetColumns(ResultSet rs) throws SQLException; 
}
