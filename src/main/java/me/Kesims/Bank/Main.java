package me.Kesims.Bank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.Kesims.Bank.bank.Bank;
import me.Kesims.Bank.bank.BankInjector;
import me.Kesims.Bank.events.NotifyCustomerEventListener;

import static me.Kesims.Bank.observer.example.Main.mainObs;
import static org.quartz.JobBuilder.newJob;



public class Main {

    public static void main(String[] args) {
        mainObs();

        Injector injector = Guice.createInjector(new BankInjector());

        Bank bank = injector.getInstance(Bank.class);
        injector.getInstance(NotifyCustomerEventListener.class);



//        try {
//
//            BasicConfigurator.configure();
//
//            // Grab the Scheduler instance from the Factory
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//
//
//            // define the job and tie it to our HelloJob class
//            JobDetail job = newJob(SimpleCronJob.class)
//                    .withIdentity("job1", "group1")
//                    .build();
//
//            // Trigger the job to run now, and then repeat every 40 seconds
//            Trigger trigger = newTrigger()
//                    .withIdentity("trigger1", "group1")
//                    .startNow()
//                    .withSchedule(simpleSchedule()
//                            .withIntervalInSeconds(5)
//                            .repeatForever())
//                    .build();
//
//            // Tell quartz to schedule the job using our trigger
//            scheduler.scheduleJob(job, trigger);
//
//
//            // and start it off
//            scheduler.start();
//
//            //scheduler.shutdown();
//
//        } catch (SchedulerException se) {
//            se.printStackTrace();
//        }




        bank.example();
        bank.startTerminal();
    }
}