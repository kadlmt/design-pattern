package factory;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 10:54
 * @description：抽象工厂模式
 * @modified By：
 * @version: 1.1
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        // 产品A1+产品B1 -> 产品A1+产品B3
        ProductA firstProductA = Factory1.getInstance().createProductA();
        ProductB firstProductB = Factory1.getInstance().createProductB();
        firstProductA.execute();
        firstProductB.execute();

        // 产品A2+产品B2
        ProductA secondProductA = Factory2.getInstance().createProductA();
        ProductB secondProductB = Factory2.getInstance().createProductB();
        secondProductA.execute();
        secondProductB.execute();

        // 产品A3+产品B3
        ProductA thirdProductA = Factory3.getInstance().createProductA();
        ProductB thirdProductB = Factory3.getInstance().createProductB();
        thirdProductA.execute();
        thirdProductB.execute();
    }

    public interface ProductA {
        void execute();
    }

    public interface ProductB {
        void execute();
    }

    public static class ProductA1 implements ProductA {

        public void execute() {
            System.out.println("产品A1的功能逻辑");
        }
    }

    public static class ProductA2 implements ProductA {

        public void execute() {
            System.out.println("产品A2的功能逻辑");
        }
    }

    public static class ProductA3 implements ProductA {

        public void execute() {
            System.out.println("产品A3的功能逻辑");
        }
    }

    public static class ProductB1 implements ProductB {

        public void execute() {
            System.out.println("产品B1的功能逻辑");
        }
    }

    public static class ProductB2 implements ProductB {

        public void execute() {
            System.out.println("产品B2的功能逻辑");
        }
    }

    public static class ProductB3 implements ProductB {

        public void execute() {
            System.out.println("产品B3的功能逻辑");
        }
    }

    public static abstract class AbstractFacoty {
        public abstract ProductA createProductA();
        public abstract ProductB createProductB();
    }

    public static class Factory1 extends AbstractFacoty {
        private static final Factory1 instance = new Factory1();

        private Factory1() {}

        public static Factory1 getInstance() {
            return instance;
        }

        public ProductA createProductA() {
            return new ProductA1();
        }

        public ProductB createProductB() {
            return new ProductB3();
        }
    }

    public static class Factory2 extends AbstractFacoty {
        private static final Factory2 instance = new Factory2();

        private Factory2() {}

        public static Factory2 getInstance() {
            return instance;
        }

        public ProductA createProductA() {
            return new ProductA2();
        }

        public ProductB createProductB() {
            return new ProductB2();
        }
    }

    public static class Factory3 extends AbstractFacoty {
        private static final Factory3 instance = new Factory3();

        private Factory3() {}

        public static Factory3 getInstance() {
            return instance;
        }

        public ProductA createProductA() {
            return new ProductA3();
        }

        public ProductB createProductB() {
            return new ProductB3();
        }
    }
}
