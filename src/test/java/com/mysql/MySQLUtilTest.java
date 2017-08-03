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


    @Test
    public void trimTest() throws Exception{
        String str = "1, 1001, F7A54574338948AC6289, F7A54574338A93429060, F7A5457433805F9E19296, F7A5457433A0D2A024836, F7A5457433A0FA1525178, F7A54574338745131500, F7A545743383AC1E26061, F7A545743390111921694, 1002, F7A54574338649AF31941, F7A5457433A7DA6A8274, F7A5457433862F7031687, F7A5457433971FDD3131, F7A5457433A7E1218338, F7A5457433835D7125429, 1003, F7A54574338961B76508, 1004, F7A545743382FF0924600, FF8080818AD0D57C73, F7A545743382F1E424523, F7A54574337F21BE17275, FF8080818AA940CC72, F7A54574337F191717236, 1005, F7A5457433A0FE1625217, 1006, F7A54574337F19F117242, 1007, F7A54574339B80CC12842, 1008, F7A545743399E73E9198, 1009, F7A54574338D2B1314795, 1010, F7A5457433830CCA24688, 1011, FF808081094D40D548";
        String str2 = str.trim();
        String []array = str.split(",");
        for(String s:array){
            System.out.println(s.trim());
        }
        System.out.println(str2);
    }
}