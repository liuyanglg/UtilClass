package com.quartz.util;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

/**
 *Created by  liuya
 *2017/12/15
 */
public class QuartzManager {
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    private final static String JOB_GROUP_NAME = "JSKP_JOB_GROUP";
    private final static String TRIGGER_GROUP_NAME = "JSKP_TRIGGER_GROUP";

    public static void addJob(String jobName, Class clazz, String time) throws SchedulerException, ParseException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = scheduler.getJobDetail(jobName, JOB_GROUP_NAME);
        if (jobDetail == null) {
            jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, clazz);
            CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);
            trigger.setCronExpression(time);
            scheduler.scheduleJob(jobDetail, trigger);
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        }
    }

    public static void removeJob(String jobName) throws SchedulerException, ParseException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.pauseTrigger(jobName, TRIGGER_GROUP_NAME);
        scheduler.unscheduleJob(jobName, TRIGGER_GROUP_NAME);
        scheduler.deleteJob(jobName, JOB_GROUP_NAME);
    }

    public static void shutdownJobs() throws SchedulerException, ParseException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        if (!scheduler.isShutdown()) {
            scheduler.shutdown();
        }
    }
}
