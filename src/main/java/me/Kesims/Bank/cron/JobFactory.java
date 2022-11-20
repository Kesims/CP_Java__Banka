package me.Kesims.Bank.cron;

import com.google.inject.Injector;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.TriggerFiredBundle;

import javax.inject.Inject;

public class JobFactory implements org.quartz.spi.JobFactory {
    private final Injector guice;

    @Inject
    public JobFactory(Injector guice) {
        this.guice = guice;
    }

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        return (Job) guice.getInstance(bundle.getJobDetail().getJobClass());
    }
}
