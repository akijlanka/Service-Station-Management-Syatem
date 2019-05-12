package lk.ijse.ssms.dao;

import lk.ijse.ssms.dbconnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtill {

    public CrudUtill() {
    }

    private static PreparedStatement getPreparedStatement(String sql, Object... para) throws SQLException, ClassNotFoundException {

        int paraCount=sql.split("[?]").length-1;
        for (int i=0; i<sql.length(); ++i){
            ;
        }
        if (paraCount != para.length){
            throw new RuntimeException("Parameter count is mismatched");
        }
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i=0; i<para.length; ++i){
            pstm.setObject(i+1,para[i]);
        }
        return pstm;


    }

    public static ResultSet executeQuery(String sql, Object... para) throws SQLException, ClassNotFoundException {
        return getPreparedStatement(sql,para).executeQuery();
    }

    public static boolean executeupdate(String sql, Object... para) throws SQLException, ClassNotFoundException {
        final boolean b = getPreparedStatement(sql, para).executeUpdate() > 0;
        return b;
    }
}
