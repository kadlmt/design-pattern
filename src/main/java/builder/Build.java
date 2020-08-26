package builder;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 22:59
 * @description：
 * @modified By：
 * @version: 1.1
 */
public interface Build {
    void buildApple(int price);
    void buildBanana(int price);
    void buildDiscount(int dicount);
    FruitMeal build();
}
