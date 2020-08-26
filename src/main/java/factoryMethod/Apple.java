package factoryMethod;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 22:11
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class Apple implements Fruit{
    private int price = 40;

    public Apple() {
    }

    public Apple(int price) {
        this.price = price;
    }

    public int price() {
        return price;
    }

    public void draw() {
        System.out.println("苹果");
    }
}
