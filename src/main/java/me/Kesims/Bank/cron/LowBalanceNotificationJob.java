package me.Kesims.Bank.cron;

import me.Kesims.Bank.accounts.AccountStorageService;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Inject;

public class LowBalanceNotificationJob implements Job {
    final int NOTIFICATION_BALANCE_THRESHOLD = 500;

    @Inject
    AccountStorageService accountStorageService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Checking accounts for low balance!");
//        for(BaseAccount account : accountStorageService.getAccounts()) {
//            if (account.getBalance() < NOTIFICATION_BALANCE_THRESHOLD) {
//                System.out.println("Warning! Low balance on account " + account.getAccountNumber() + " owned by "
//                        + account.getOwner().getFullName() + "! (" + account.getBalance() + ")");
//            }
//        }
    }
}
