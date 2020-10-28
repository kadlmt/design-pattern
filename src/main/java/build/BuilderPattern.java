package build;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 15:00
 * @description：构造器模式
 * @modified By：
 * @version: 1.1
 */
public class BuilderPattern {
    // 好处1：通过builder接口将复杂构建步骤拆分成了多个部分，代码逻辑清晰，维护性和扩展性都很好
    // 好处2：将对象构建的过程，封装在了director里面，director来基于builder进行构建，构建逻辑修改，不需要修改很多地方
    // 好处3：相对于工厂，有一个很好的抽象设计，director和builder
    public static void main(String[] args) {
        Product product = new Director(new ConcreteBuilder()).build("值1", "值2", "值3");
        System.out.println(product);
    }

    public static class Product {
        private String field1;
        private String field2;
        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "field1='" + field1 + '\'' +
                    ", field2='" + field2 + '\'' +
                    ", field3='" + field3 + '\'' +
                    '}';
        }
    }

    public interface Builder {
        void field1(String value);
        void field2(String value);
        void field3(String value);
        Product create();
    }

    public static class ConcreteBuilder implements Builder {
        private Product product = new Product();

        public void field1(String value) {
            System.out.println("在设置field1之前进行复杂的校验逻辑");
            product.setField1(value);
        }

        public void field2(String value) {
            System.out.println("在设置field2之前进行复杂的校验逻辑");
            product.setField2(value);
        }

        public void field3(String value) {
            System.out.println("在设置field3之前进行复杂的校验逻辑");
            product.setField3(value);
        }

        public Product create() {
            return product;
        }
    }

    public static class Director {
        private Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public Product build(String field1, String field2, String field3) {
            builder.field1(field1);
            builder.field2(field2);
            builder.field3(field3);
            return builder.create();
        }
    }
}
