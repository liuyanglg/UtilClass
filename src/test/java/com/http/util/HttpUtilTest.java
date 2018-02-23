package com.http.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *Created by  liuya
 *2017/12/7
 */
public class HttpUtilTest {

    @Test
    public void queryCompanyIdApi() throws Exception{
        String url = "http://localhost:9222/nuonuo/invoice/getKpInfoByMerchantTaxnum.action";
        HttpUtil.post(url);
}

    @Test
    public void postMethod() throws Exception{
        String url = "http://localhost:9222/nuonuo/invoice/getKpInfoByMerchantTaxnum.action";
//        String url = "http://www.baidu.com";
        HttpUtil.postMethod(url);
    }
}