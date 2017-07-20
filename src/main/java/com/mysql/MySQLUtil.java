package com.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mysql.MySQLProperties.*;

/**
 * Created by liuya on 2017/7/20.
 */
public class MySQLUtil {
//    private static Connection connection;

    public static Connection getConnection(String driver, String url, String username, String password) {
//        Connection connection;
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            if (!connection.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS tb_base_code_serviceid(\n" +
                "\tcode VARCHAR(16) PRIMARY KEY NOT NULL,\n" +
                "\tserviceid VARCHAR(35) NOT NULL\n" +
                ")";
        Connection connection = getConnection(CMP_DRIVER, CMP_URL, CMP_USERNAME, CMP_PASSWORD);
        Statement stat = null;
        if (connection != null) {
            try {
                stat = connection.createStatement();
                stat.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                    if (stat != null) {
                        stat.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Map<String, Object>> queryBySql(String sql) {
        List<Map<String, Object>> queryResult = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Statement stat=null;
        ResultSetMetaData md = null;
        Connection connection = getConnection(CMP_DRIVER, CMP_URL, CMP_USERNAME, CMP_PASSWORD);

        pst = connection.prepareStatement(sql);
        rs = pst.executeQuery();
        md = rs.getMetaData();
        int columns = md.getColumnCount();
        while(rs.next()){
            Map<String, Object> map = new HashMap<String,Object>();
            for(int i=0;i<columns;i++){
                map.put(md.getColumnName(i+1),getValueByType(rs, md.getColumnType(i + 1), md.getColumnName(i + 1)));
            }
        }
        for(int i=0;i<columns;i++){

        }
        stat = connection.createStatement();
        stat.execute(sql)

        return queryResult;
    }

    /***
     *
     * @param rs 查询出来的结果集
     * @param type SQL type from java.sql.Types
     * @param name 数据库记录所对应的字段名称
     * @return 返回一条记录的一个列值
     * @throws SQLException
     */
    private static Object getValueByType(ResultSet rs, int type, String name) throws SQLException{
        switch(type){
            case Types.NUMERIC:
                return rs.getLong(name);
            case Types.VARCHAR:
                //if(rs.getString(name)==null){
                //return "";
                //}
                return rs.getString(name);
            case Types.DATE:
                //if(rs.getDate(name)==null){
                //return System.currentTimeMillis();
                //  }
                return rs.getDate(name);
            case Types.TIMESTAMP:
                return rs.getTimestamp(name).toString().substring(0,rs.getTimestamp(name).toString().length()-2);
            case Types.INTEGER:
                return rs.getInt(name);
            case Types.DOUBLE:
                return rs.getDouble(name);
            case Types.FLOAT:
                return rs.getFloat(name);
            case Types.BIGINT:
                return rs.getLong(name);
            default:
                return rs.getObject(name);
        }
    }

}
