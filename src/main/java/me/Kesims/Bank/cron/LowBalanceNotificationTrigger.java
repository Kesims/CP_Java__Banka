package me.Kesims.Bank.cron;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.spi.TriggerFiredBundle;

import javax.inject.Inject;
import javax.inject.Singleton;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Singleton
public class LowBalanceNotificationTrigger implements JobTrigger{

    final int EXECUTION_INTERVAL = 60;

    @Inject
    LowBalanceNotificationJob lowBalanceNotificationJob;

    @Inject
    JobFactory jobFactory;

    @Override
    public void register(Scheduler scheduler) {
        // define the job and tie it to our class

        JobDetail job = newJob(LowBalanceNotificationJob.class)
                .withIdentity("LowBalanceNotification", "BankNotify")
                .build();

        // Trigger the job to run now, and then repeat every xx seconds
        Trigger trigger = newTrigger()
                .withIdentity("LowBalanceNotificationTrigger", "BankNotify")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(EXECUTION_INTERVAL)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
