package com.string.example001;

/**
 *Created by  liuya
 *2017/12/28
 */
public class StringCompare {
    private static final String testStr = "SELECT A.`code`  AS `code`, A.`taxid` AS `taxid`, M.`taxid` AS `taxidM` FROM `tb_cmp_card_audit` A LEFT JOIN `tb_cmp_card` M ON A.`code` = M.`code` WHERE A.`createtime` >= DATE_SUB(NOW(), INTERVAL 1 DAY) A.id> ";
    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();
//        StringTest();
//       StringBufferTest();
       StringBuilderTest();
        long afterTime = System.currentTimeMillis();
        System.out.println("time: " + (afterTime - beforeTime));
        long memory = Runtime.getRuntime().totalMemory()
                - Runtime.getRuntime().freeMemory();
        System.out.println("memory: " + memory);
    }

    private static void StringTest() {

        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += testStr + i + ";";
        }
    }

    private static void StringBufferTest() {

        StringBuffer stringBuffer = new StringBuffer(testStr);
        for (int i = 0; i < 10000; i++) {
            stringBuffer = stringBuffer
                    .append(i + ";");
        }
    }

    private static void StringBuilderTest() {

        StringBuilder stringBuilder = new StringBuilder(testStr);
        for (int i = 0; i < 10000; i++) {
            stringBuilder = stringBuilder
                    .append(i + ";");
        }
    }
}
