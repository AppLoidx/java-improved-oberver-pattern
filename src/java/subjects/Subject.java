package subjects;


import annotations.ObserverController;
import annotations.Subscriber;
import observers.FirstObserver;
import observers.SecondObserver;
import subjects.additional.Time;
import subjects.additional.User;

/**
 * @author Arthur Kupriyanov
 */
@annotations.Subject(
        eventType = EventType.class,
        subscribers = {
            @Subscriber(FirstObserver.class),
            @Subscriber(value = SecondObserver.class, params = {User.class, Time.class, EventType.class}),
            @Subscriber(value = SecondObserver.class, params = {User.class})
        }
)
public class Subject {
    @ObserverController
    private manager.ObserverController observerController;

    private User user;
    private Time time;

    public Subject(User user, Time time){
        this.user = user;
        this.time = time;
    }


    public void someAction(){

        // something ...

        observerController.notifySubscribers(user, time);
        // calls @Subscriber(value = SecondObserver.class, params = {User.class, Time.class})
    }

    public void someAction(User user){

        // something ...

        observerController.notifySubscribers(user);
        // calls @Subscriber(value = SecondObserver.class, params = {User.class})
    }

    public void someActionForFirstObserver(){
        observerController.notifySubscribers();
        // calls @Subscriber(FirstObserver.class)
    }

}
