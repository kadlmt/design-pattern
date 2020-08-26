package factoryMethod;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 22:07
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class Banana implements Fruit {
    private int price = 60;

    public Banana() {
    }

    public Banana(int price) {
        this.price = price;
    }

    public int price() {
        return price;
    }

    public void draw() {
        System.out.println("香蕉");
    }
}
