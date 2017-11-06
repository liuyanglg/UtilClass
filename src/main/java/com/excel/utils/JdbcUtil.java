package com.excel.utils;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class JdbcUtil {
    public static Connection getConnection(String driver, String url, String username, String password) {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            if (!connection.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection x) {
        if (x == null) {
            return;
        }
        try {
            x.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement x) {
        if (x == null) {
            return;
        }
        try {
            x.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet x) {
        if (x == null) {
            return;
        }
        try {
            x.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeBatchUpdate(Connection conn, String sql, List<Map<String,Object>>paramMapList,String ...keys){
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            int batchSize=500;
            int size=0;
            for(int i=0;i<paramMapList.size();i++){
                Map<String, Object> parameters = paramMapList.get(i);
                if(parameters!=null) {
                    setParameters(stmt,parameters,keys);
                }
                stmt.addBatch();
                size++;
                if(size%batchSize==0){
                    stmt.executeBatch();
                    size=0;
                }
            }
            if(size!=0){
                stmt.executeBatch();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(stmt);
            close(conn);
        }

    }

    private static void setParameters(PreparedStatement stmt, Map<String,Object> parameters) throws SQLException {
        for (int i = 0, size = parameters.size(); i < size; ++i) {
            Object param = parameters.get(i);
            stmt.setObject(i + 1, param);
        }
    }

    private static void setParameters(PreparedStatement stmt, Map<String,Object> parameters, String ...keys) throws Exception {
        int index=0;
        Object convertParam = null;

        for(String key:keys){
            Object param = parameters.get(key);
            if(param!=null){
                String paramStr = ((String) param).replaceAll("@","");
                convertParam = paramStr;
                if(key!=null&&key.trim().equals("id")){
                    Integer id = Integer.parseInt(paramStr);
                    convertParam = id;
                }
            }
            stmt.setObject(++index,convertParam);
        }
    }
}
