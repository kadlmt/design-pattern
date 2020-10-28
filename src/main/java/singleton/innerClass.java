package singleton;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 11:34
 * @description：内部类
 * @modified By：
 * @version: 1.1
 */
public class innerClass {
    public static class Singleton {
        private Singleton() {}

        public Singleton getInstance() {
            return HoldInstance.instance;
        }

        public static class HoldInstance {
            private static final Singleton instance = new Singleton();
        }
    }
}
