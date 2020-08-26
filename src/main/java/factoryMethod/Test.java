package factoryMethod;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 22:18
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class Test {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new AppleFactory();
        Fruit fruit = fruitFactory.getFruit();
        fruit.draw();
    }
}
