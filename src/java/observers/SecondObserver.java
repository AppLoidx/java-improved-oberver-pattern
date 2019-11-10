package observers;

import annotations.SubscriberMethod;
import subjects.EventType;
import subjects.additional.Time;
import subjects.additional.User;

/**
 * @author Arthur Kupriyanov
 */
public class SecondObserver {

    @SubscriberMethod
    public void notificationHandle(User user , Time time){

    }

    @SubscriberMethod
    public void anotherNotificationHandle(User user, Time time, EventType eventType){

    }

    @SubscriberMethod
    public void notificationHandle(User user){

    }
}
