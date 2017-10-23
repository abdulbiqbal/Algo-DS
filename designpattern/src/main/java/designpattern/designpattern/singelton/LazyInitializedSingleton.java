package designpattern.designpattern.singelton;

/**
 * http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples#thread-safe-singleton
 * @author servsingh
 *
 */
public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}
    
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
