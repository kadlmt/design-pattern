package builder;

import factoryMethod.Apple;
import factoryMethod.Banana;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 22:49
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class FruitMeal {
    private Apple apple;
    private Banana banana;
    private int totolPrice;
    private int discount;

    public void setApple(int price) {
        this.apple = new Apple(price);
    }

    public void setBanana(int price) {
        this.banana = new Banana(price);
    }

    public void setTotolPrice(int totolPrice) {
        this.totolPrice = totolPrice;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
