package me.Kesims.Bank.cron;

import me.Kesims.Bank.accounts.services.InterestManagerService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Inject;

public class AccountInterestManagerJob implements Job {

    @Inject
    InterestManagerService interestManagerService;


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        interestManagerService.addInterests();
        System.out.println("Adding interests to savings accounts.");
    }
}
