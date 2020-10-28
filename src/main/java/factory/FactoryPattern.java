package factory;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 10:20
 * @description：工厂模式
 * @modified By：
 * @version: 1.1
 */
public class FactoryPattern {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Product product = factory.createProduct();
        product.execute();
    }

    public interface Product {
        void execute();
    }

    public static class ProductImpl implements Product {

        public void execute() {
            System.out.println("产品的功能实现");
        }
    }

    public static class Factory {
        Product createProduct() {
            return new ProductImpl();
        }
    }
}
