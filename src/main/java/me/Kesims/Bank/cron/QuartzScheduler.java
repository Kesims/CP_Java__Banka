package me.Kesims.Bank.cron;

import me.Kesims.Bank.accounts.AccountStorageService;
import me.Kesims.Bank.cron.examples.SimpleCronJobTrigger;
import org.apache.log4j.BasicConfigurator;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class QuartzScheduler {

    @Inject
    SimpleCronJobTrigger exampleJobTrigger;

    @Inject
    LowBalanceNotificationTrigger lowBalanceNotificationTrigger;

    @Inject
    AccountInterestManagerJobTrigger accountInterestManagerJobTrigger;

    @Inject
    AccountStorageService accountStorageService;

    private Scheduler scheduler;

    public void registerJobs() {
        try {
            BasicConfigurator.configure();

            this.scheduler = StdSchedulerFactory.getDefaultScheduler();

//            exampleJobTrigger.register(scheduler);
            lowBalanceNotificationTrigger.register(scheduler);
            accountInterestManagerJobTrigger.register(scheduler);

            System.out.println(accountStorageService.getAccounts());

            scheduler.start();
        }
        catch (SchedulerException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void shutdownScheduler() {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

}
