package singleton;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 11:31
 * @description：双重检锁
 * @modified By：
 * @version: 1.1
 */
public class DoubleCheck {
    public static class Singleton {
        private volatile static Singleton instance;

        private Singleton() {}

        public static Singleton getInstance() {
            if(instance == null) {
                synchronized (Singleton.class) {
                    if(instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}
