package me.Kesims.Bank.cron;

import org.quartz.Scheduler;

public interface JobTrigger {
    public void register(Scheduler scheduler);
}
