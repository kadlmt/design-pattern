package builder;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/26 23:10
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class test {
    public static void main(String[] args) {
        Build build = new Builder();
        build.buildApple(1);
        build.buildBanana(2);
        build.buildDiscount(10);
        FruitMeal fruitMeal = build.build();

    }
}
