package me.Kesims.Bank.cron;

import org.apache.log4j.BasicConfigurator;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class QuartzScheduler {

    @Inject
    ExampleJobTrigger exampleJobTrigger;

    public void registerJobs() {
        try {
            BasicConfigurator.configure();

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            exampleJobTrigger.register(scheduler);

            scheduler.start();
        }
        catch (SchedulerException exception) {
            throw new RuntimeException(exception);
        }
    }

}
