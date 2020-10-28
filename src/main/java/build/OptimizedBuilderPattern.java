package build;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 15:18
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class OptimizedBuilderPattern {
    public static void main(String[] args) {
        Product product = new ConcreteBuilder().field1("1")
                .field2("2").field3("3").create();
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
        Builder field1(String value);
        Builder field2(String value);
        Builder field3(String value);
        Product create();
    }

    public static class ConcreteBuilder implements Builder {
        private Product product = new Product();

        public Builder field1(String value) {
            System.out.println("在设置field1之前进行复杂的校验逻辑");
            product.setField1(value);
            return this;
        }

        public Builder field2(String value) {
            System.out.println("在设置field2之前进行复杂的校验逻辑");
            product.setField2(value);
            return this;
        }

        public Builder field3(String value) {
            System.out.println("在设置field3之前进行复杂的校验逻辑");
            product.setField3(value);
            return this;
        }

        public Product create() {
            return product;
        }
    }
}
