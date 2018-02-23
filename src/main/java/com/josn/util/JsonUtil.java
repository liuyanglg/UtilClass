package com.josn.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javafx.beans.binding.ObjectExpression;

import java.util.*;

/**
 *Created by  liuya
 *2017/12/7
 */
public class JsonUtil {
    private static String json = "[{\n" +
            "    \"c_kpcode\": \"330181685809434\",\n" +
            "    \"c_kpaddr\": \"萧山区\",\n" +
            "    \"c_kpname\": \"杭州奥体\",\n" +
            "    \"c_kptel\": \"83782118\",\n" +
            "    \"c_bank_account\": \"356980100100277069\",\n" +
            "    \"c_account_blank\": \"兴业银行\",\n" +
            "    \"adddate\": \"2017-11-29 16:22:27\",\n" +
            "    \"remarks\": \"\",\n" +
            "    \"source\": \"10\",\n" +
            "    \"alipayuserid\": \"330411307368790\",\n" +
            "    \"invoicetype\": \"1\"\n" +
            "},{\n" +
            "    \"c_kpcode\": \"330181685809435\",\n" +
            "    \"c_kpaddr\": \"萧山区2\",\n" +
            "    \"c_kpname\": \"杭州奥体2\",\n" +
            "    \"c_kptel\": \"837821182\",\n" +
            "    \"c_bank_account\": \"3569801001002770692\",\n" +
            "    \"c_account_blank\": \"兴业银行2\",\n" +
            "    \"adddate\": \"2017-11-29 16:22:27\",\n" +
            "    \"remarks\": \"\",\n" +
            "    \"source\": \"10\",\n" +
            "    \"alipayuserid\": \"330411307368790\",\n" +
            "    \"invoicetype\": \"1\"\n" +
            "}]";

    public static String jsonToMap(String result, String extension) {
        JSONArray jsonArray = JSON.parseArray(result);
        int size = jsonArray.size();

        List<Map<String, Object>> list = null;

        if (size > 0) {
            list = new ArrayList<Map<String, Object>>();
        } else {
            return result;
        }

        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            Map<String, Object> map1 = new LinkedHashMap<String, Object>();
            Map<String, Object> map2 = new LinkedHashMap<String, Object>();
            for (String key : jsonObject.keySet()) {
                map1.put(key, jsonObject.get(key));
            }
            map2.putAll(map1);
            String kpCode = (String) map1.get("c_kpcode");
            map2.put("c_kpcode", kpCode + "." + extension);

            list.add(map1);
            list.add(map2);
        }
        return JSON.toJSONString(list);
    }

    public static void main(String[] args) {
        System.out.println(jsonToMap(json, "1122"));
    }
}
