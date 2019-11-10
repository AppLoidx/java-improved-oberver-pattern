package manager;

/**
 * @author Arthur Kupriyanov
 */
public interface ObserverController {
    public void notifySubscribers(Object ... args);
}
