package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                // INSERT YOUR CODE HERE
                ResultSetMetaData rsmd = rs.getMetaData();      // getting the metadata
                
                // iterate through result set
                while(rs.next()) {
                    JsonObject jObj = new JsonObject();     // json object to hold our data
                    // iterate throguh each column
                    for(int i = 1; i <= rsmd.getColumnCount(); i++) {
                        // get values for object
                        String colName = rsmd.getColumnName(i);
                        String colValue = rs.getObject(i).toString();
                        // put values into object
                        jObj.put(colName, colValue);
                    }
                    // add json object value to records
                    records.add(jObj);
                }
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
