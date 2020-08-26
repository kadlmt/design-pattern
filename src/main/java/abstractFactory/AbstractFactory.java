package abstractFactory;

import factoryMethod.Fruit;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 22:29
 * @description：
 * @modified By：
 * @version: 1.1
 */
public abstract class AbstractFactory {
    abstract Fruit getFruit();
    abstract Bag getBag();
}
