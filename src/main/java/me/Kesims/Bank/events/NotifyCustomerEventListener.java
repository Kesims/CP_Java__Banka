package me.Kesims.Bank.events;

import com.google.common.eventbus.Subscribe;

import javax.inject.Singleton;

@Singleton
public class NotifyCustomerEventListener {

    @Subscribe
    public void notifyCustomerEvent(NotifyCustomerEvent notifyCustomerEvent) {
        System.out.println("EVENT FIRED: " +  notifyCustomerEvent.getNotificationData().getPersonName());
    }
}
