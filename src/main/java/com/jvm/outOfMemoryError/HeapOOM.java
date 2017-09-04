package com.jvm.outOfMemoryError;

import java.util.ArrayList;
import java.util.List;
/**
 * VM Args：-Xms20m-Xmx20m -XX：+HeapDumpOnOutOfMemoryError
 * @Package : com.jvm.outOfMemoryError
 * @Class : HeapOOM
 * @Description : 堆内存溢出实例
 * @Author : liuya
 * @CreateDate : 2017-09-04 星期一 16:26:25
 * @Version : V1.0.0
 * @Copyright : 2017 liuya Inc. All rights reserved.
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}