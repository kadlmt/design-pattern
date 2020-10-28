package singleton;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 11:26
 * @description：饿汉
 * @modified By：
 * @version: 1.1
 */
public class Hungry {
    public static class Singleton {
        private static final Singleton instance = new Singleton();

        private Singleton() {}

        private static Singleton getInstance() {
            return instance;
        }
    }
}
