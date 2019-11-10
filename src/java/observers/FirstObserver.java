package observers;

import annotations.Observer;
import annotations.SubscriberMethod;
import subjects.EventType;

/**
 * @author Arthur Kupriyanov
 */
@Observer
public class FirstObserver {
    @SubscriberMethod
    public void getNotification(){

    }
}
