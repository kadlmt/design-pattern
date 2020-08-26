package factoryMethod;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 22:06
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class BananaFactory implements FruitFactory {
    public Fruit getFruit() {
        return new Banana();
    }
}
