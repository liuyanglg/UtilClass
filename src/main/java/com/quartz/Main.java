package com.quartz;

import com.quartz.util.JobTask;
import com.quartz.util.QuartzManager;

/**
 *Created by  liuya
 *2017/12/15
 */
public class Main {
    private static String jobName = "rechargeJob";
    private static String triggerTime = "0 0/1 * * * ?";

    public static void main(String[] args) throws Exception {
        while (true) {
            QuartzManager.addJob(jobName, JobTask.class, triggerTime);
            Thread.sleep(10000);
        }
    }
}
