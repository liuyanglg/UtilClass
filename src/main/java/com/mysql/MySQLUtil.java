package com.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package : com.mysql
 * @Class : MySQLUtil
 * @Description : 
 * @Author : liuya
 * @CreateDate : 2017-08-07 星期一 17:45:23
 * @Version : V1.0.0
 * @Copyright : 2017 liuya Inc. All rights reserved.
 */
public class MySQLUtil {

    public static Connection getConnection(String driver, String url, String username, String password) {
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

    public static void createTable(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS tb_base_code_serviceid_xxx(\n" +
                "\tcode VARCHAR(16) PRIMARY KEY NOT NULL,\n" +
                "\tserviceid VARCHAR(35) NOT NULL\n" +
                ")";
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

    public static void execSql(Connection connection,String sql){
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

    /**
     * @param sql   sql语句
     * @param connection    MySQL连接
     * @return 查询结果list集合
     */
    public static List<Map<String, Object>> queryBySql(String sql, Connection connection) {
        List<Map<String, Object>> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSetMetaData rsmd = null;
        ResultSet rs = null;
        int columns;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columns = rsmd.getColumnCount();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 0; i < columns; i++) {
                    map.put(rsmd.getColumnName(i + 1), getValueByType(rs, rsmd.getColumnType(i + 1), rsmd.getColumnName(i + 1)));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static void insertBatch(String sql,Connection connection,List<Map<String,Object>> params){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for(Map<String,Object>param:params){
                String serviceid= (String) param.get("c_serviceid");
                String code= (String) param.get("c_taxnum");
                ps.setString(1,serviceid);
                ps.setString(2,code);
                ps.addBatch();
            }
            Long timeStart = System.currentTimeMillis();
            ps.executeBatch();//批量更新
            Long timeEnd = System.currentTimeMillis();
            System.out.println((timeEnd-timeStart)+"ms");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param rs   查询出来的结果集
     * @param type SQL type from java.sql.Types
     * @param name 数据库记录所对应的字段名称
     * @return 返回一条记录的一个列值
     * @throws SQLException
     */
    private static Object getValueByType(ResultSet rs, int type, String name) throws SQLException {
        switch (type) {
            case Types.NUMERIC:
                return rs.getLong(name);
            case Types.VARCHAR:
                return rs.getString(name);
            case Types.DATE:
                return rs.getDate(name);
            case Types.TIMESTAMP:
                return rs.getTimestamp(name).toString().substring(0, rs.getTimestamp(name).toString().length() - 2);
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
