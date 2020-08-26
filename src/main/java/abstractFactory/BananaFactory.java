package abstractFactory;

import factoryMethod.Fruit;
import factoryMethod.FruitFactory;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 22:06
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class BananaFactory extends AbstractFactory{
    public Fruit getFruit() {
        return new Banana();
    }

    Bag getBag() {
        return new BaBag();
    }
}
