package builder;

import factoryMethod.Apple;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 23:01
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class Builder implements Build {
    private FruitMeal fruitMeal = new FruitMeal();
    public void buildApple(int price) {
        fruitMeal.setApple(price);
    }

    public void buildBanana(int price) {
        fruitMeal.setBanana(price);
    }

    public void buildDiscount(int dicount) {
        fruitMeal.setDiscount(dicount);
    }

    public FruitMeal build() {
        return fruitMeal;
    }
}
