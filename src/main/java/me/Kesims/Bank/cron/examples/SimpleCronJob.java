package me.Kesims.Bank.cron.examples;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleCronJob implements Job {

    private Logger log = Logger.getLogger(SimpleCronJob.class);


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("SimpleCronJob has been executed!");
    }
}
