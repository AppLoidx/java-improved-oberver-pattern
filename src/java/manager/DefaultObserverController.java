package manager;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Arthur Kupriyanov
 */
public class DefaultObserverController implements ObserverController{

    private Class<?> subject;

    public DefaultObserverController(Class<?> subject){
        this.subject = subject;
    }
    @Override
    public void notifySubscribers(Object... args) {
        Class<?>[] signature = new Class<?>[args.length];
        Set<Class<?>> usedParamTypes = new HashSet<>();

        int index = 0;
        for (Object obj : args){
            if (usedParamTypes.contains(obj.getClass())){
                try {
                    throw new Exception("Duplicated signature method");
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            signature[index] = obj.getClass();
            usedParamTypes.add(obj.getClass());
            index++;
        }

        for (Method m : subject.getDeclaredMethods()){
            if (checkIsEqual(m.getParameterTypes(), signature)){
                // TODO: write down
            }
        }

    }

    private boolean checkIsEqual(Class<?>[] parameterTypes, Class<?>[] signature){
        if (parameterTypes.length != signature.length) return false;

        for (Class c : signature){
            boolean founded = false;
            for (Class cInner : parameterTypes){
                if (cInner.equals(c)){
                    founded = true;
                    break;
                }
            }
            if (!founded) return false;
        }

        return true;
    }
}
