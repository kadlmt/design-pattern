package flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 15:24
 * @description：享元模式
 * @modified By：
 * @version: 1.1
 */
public class UseFlyWeightPattern {
    public static void main(String[] args) {
        Flyweight flyweight1 = FlyweightFactory.get("对象1");
        flyweight1.execute();

        Flyweight flyweight2 = FlyweightFactory.get("对象1");
        flyweight2.execute();

        System.out.println(flyweight1 == flyweight2);
    }

    public interface Flyweight {
        void execute();
    }

    public static class ConcreteFlyweight implements Flyweight {
        private String name;

        public ConcreteFlyweight(String name) {
            this.name = name;
        }

        public void execute() {
            System.out.println(name + "执行业务逻辑");
        }
    }

    public static class FlyweightFactory {
        private static Map<String, Flyweight> cachePool = new HashMap<>();

        public static Flyweight get(String name) {
            Flyweight flyweight = cachePool.get(name);
            if(flyweight == null) {
                flyweight = new ConcreteFlyweight(name);
                cachePool.put(name,  flyweight);
            }
            return flyweight;
        }
    }
}
