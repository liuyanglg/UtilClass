package com.http.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 *Created by  liuya
 *2017/12/7
 */
public class HttpUtil {

    public static Map<String, String> post(String url) throws Exception, IOException {
        Map<String, String> resultMap = null;
        String resultJsonStr = "";

        HttpClient httpclient = null;
        PostMethod post = null;
        httpclient = new org.apache.commons.httpclient.HttpClient();
        httpclient.setConnectionTimeout(50000);
        httpclient.setTimeout(50000);
        post = new PostMethod(url);
        String paramName = "+tMkOIjJVVbHKDVGRhmL6bBDbI55sBDIvS5RfcmZb48tcZR99l0XsRrFP/ZYdfdRy3X16ICp8u7B\n" +
                "pgueiHBJ+BjElabPv/kidhbH5bLwYeE=";
        post.addParameter("paramName", paramName);
        httpclient.executeMethod(post);
        resultJsonStr = new String(post.getResponseBody(), "utf-8");
        resultMap = (Map<String, String>) JSON.parse(resultJsonStr);

        return resultMap;
    }

    public static String postMethod(String url) throws Exception{
        String result = null;
        CloseableHttpClient closeableHttpClient = null;
        try {
            closeableHttpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-type", "application/json");


            String paramName = "+tMkOIjJVVbHKDVGRhmL6bBDbI55sBDIvS5RfcmZb48tcZR99l0XsRrFP/ZYdfdRy3X16ICp8u7B\n" +
                    "pgueiHBJ+BjElabPv/kidhbH5bLwYeE=";

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("paramName", paramName));

            httpPost.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                 result = EntityUtils.toString(entity);
            }
        } finally {
            if (closeableHttpClient != null) {
                closeableHttpClient.close();
            }
        }
        return result;
    }
}
