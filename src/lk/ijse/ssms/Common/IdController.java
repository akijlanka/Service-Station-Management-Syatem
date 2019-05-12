package lk.ijse.ssms.Common;



import lk.ijse.ssms.dbconnection.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IdController {

    public static String getLastID(String tbname, String columnName) throws SQLException, ClassNotFoundException {
        String query="select "+columnName+" from "+tbname+" order by 1 desc limit 1";
        Connection connection= DBConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet rst=statement.executeQuery(query);

        if (rst.next()){
            return rst.getString(1);
        }
        return null;

    }
    }

