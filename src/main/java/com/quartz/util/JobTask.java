package com.quartz.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *Created by  liuya
 *2017/12/15
 */
public class JobTask implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("task has run");
    }
}
