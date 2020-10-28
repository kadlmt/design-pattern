package prototype;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 17:25
 * @description：原型模式
 * @modified By：
 * @version: 1.1
 */
public class UsePrototypePattern {
    public static void main(String[] args) {
        try {
            Product product = new Product("测试产品", new Component("测试组件"));
            Product copyProduct = (Product) product.clone();
            System.out.println(copyProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 原型模式，就是在要拷贝的类里实现一个clone()方法，自己拷贝自己
        // 拷贝的时候，就两个概念，浅拷贝，深拷贝

        // 很多地方要克隆这个对象，不要自己维护克隆的逻辑，即使克隆逻辑修改了，只要在clone()方法里面修改
    }

    public static class Product {
        private String name;
        private Component component;

        public Product(String name, Component component) {
            this.name = name;
            this.component = component;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Component getComponent() {
            return component;
        }

        public void setComponent(Component component) {
            this.component = component;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            //深拷贝
            return new Product(getName(), (Component)getComponent().clone());
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", component=" + component +
                    '}';
        }
    }

    public static class Component {
        private String name;

        public Component(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "component{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new Component(getName());
        }
    }


}
