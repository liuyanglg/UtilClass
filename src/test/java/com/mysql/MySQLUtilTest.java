package com.mysql;

import org.junit.Test;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static com.mysql.MySQLProperties.*;

/**
 * Created by liuya on 2017/7/20.
 */
public class MySQLUtilTest {
    @Test
    public void queryBySql() throws Exception {
        Connection conPlatformkf = MySQLUtil.getConnection(CMP_DRIVER, CMP_URL_PLATFORMKF, CMP_USERNAME, CMP_PASSWORD);
        String sqlTaxService = " SELECT t.c_serviceid,t.c_texnum " +
                "FROM portal_buyer_bind_service t " +
                "WHERE t.c_texnum IS NOT NULL AND t.c_texnum!='' " +
                "AND t.c_serviceid IS NOT NULL AND t.c_serviceid!='' " +
                "GROUP BY t.c_serviceid;";
        List<Map<String, Object>> taxServiceList = MySQLUtil.queryBySql(sqlTaxService, conPlatformkf);
        Connection conDataServer = MySQLUtil.getConnection(CMP_DRIVER, CMP_URL_DATASERVER, CMP_USERNAME, CMP_PASSWORD);
        String sqlTaxCode = "SELECT t.`taxid`,t.`code` " +
                "FROM tb_base_taxid_code t " +
                "WHERE t.`taxid`!='' AND t.`taxid` IS NOT NULL " +
                "AND t.`code`!='' AND t.`code` IS NOT NULL;";
        List<Map<String, Object>> taxCodeList = MySQLUtil.queryBySql(sqlTaxCode, conDataServer);
    }

    @Test
    public void createTable() throws Exception {
        Connection connection = MySQLUtil.getConnection(CMP_DRIVER, CMP_URL_DATASERVER, CMP_USERNAME, CMP_PASSWORD);
        MySQLUtil.createTable(connection);
    }

}