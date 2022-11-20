package me.Kesims.Bank.cron.examples;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;

public class ExampleJobFactory implements JobFactory {

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        return null;

        // what the fuck is TriggerFiredBundle :((( Not sure how to use this :/
    }
}
