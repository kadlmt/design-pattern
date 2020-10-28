package template;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/28 9:59
 * @description：模板方法模式
 * @modified By：
 * @version: 1.1
 */
public class UseTemplateMethodPattern {

    public static void main(String[] args) {
        DiscountCalculator calculator1 = new DiscountCalculator1();
        calculator1.calculate();

        DiscountCalculator calculator2 = new DiscountCalculator1();
        calculator2.calculate();

        DiscountCalculator calculator3 = new DiscountCalculator1();
        calculator3.calculate();
    }

    public interface DiscountCalculator {
        void calculate();
    }

    public static abstract class AbstractDiscountCalculator implements DiscountCalculator {
        public void calculate(){
            commonCalculate();
            specialCalculate();
        }

        private void commonCalculate(){
            System.out.println("通用的计算逻辑");
        }

        protected abstract void specialCalculate();
    }

    public static class DiscountCalculator1 extends AbstractDiscountCalculator {

        public void specialCalculate() {
            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }

    public static class DiscountCalculator2 extends AbstractDiscountCalculator {

        public void specialCalculate() {
            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }

    public static class DiscountCalculator3 extends AbstractDiscountCalculator {

        public void specialCalculate() {
            System.out.println("优惠计算器1的特殊计算逻辑");
        }
    }
}
