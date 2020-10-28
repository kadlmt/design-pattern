package factory;

import template.UseTemplateMethodPattern;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 10:25
 * @description：工厂方法模式
 * @modified By：
 * @version: 1.1
 */
public class FactoryMethodPattern {
    public static void main(String[] args) {
        Product product1 = Product1Factory.getInstance().createProduct();
        Product product2 = Product2Factory.getInstance().createProduct();
        Product product3 = Product3Factory.getInstance().createProduct();
    }

    public interface Product {
        void execute();
    }

    public static class Product1 implements Product {

        public void execute() {
            System.out.println("产品1的功能逻辑");
        }
    }

    public static class Product2 implements Product {

        public void execute() {
            System.out.println("产品2的功能逻辑");
        }
    }

    public static class Product3 implements Product {

        public void execute() {
            System.out.println("产品3的功能逻辑");
        }
    }

    public static abstract class AbstractProductFactory {
        Product createProduct() {
            commonCreate();
            return specialCreate();
        }

        private void commonCreate() {
            System.out.println("生产产品的通用逻辑");
        }

        public abstract Product specialCreate();
    }

    public static class Product1Factory extends AbstractProductFactory {
        private static final Product1Factory instance = new Product1Factory();

        private Product1Factory() {}

        public static Product1Factory getInstance() {
            return instance;
        }

        public Product specialCreate() {
            return new Product1();
        }
    }

    public static class Product2Factory extends AbstractProductFactory {
        private static final Product2Factory instance = new Product2Factory();

        private Product2Factory() {}

        public static Product2Factory getInstance() {
            return instance;
        }

        public Product specialCreate() {
            return new Product2();
        }
    }

    public static class Product3Factory extends AbstractProductFactory {
        private static final Product3Factory instance = new Product3Factory();

        private Product3Factory() {}

        public static Product3Factory getInstance() {
            return instance;
        }

        public Product specialCreate() {
            return new Product3();
        }
    }
}
