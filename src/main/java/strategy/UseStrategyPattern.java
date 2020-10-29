package strategy;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 14:26
 * @description：策略模式
 * @modified By：
 * @version: 1.1
 */
public class UseStrategyPattern {
    public static void main(String[] args) {
        int strategy = 1;
        DiscountCalculatorStrategy discountCalculatorStrategy =
                DiscountCalculatorStrategyFactory.getDiscountCalculatorStrategy(strategy);
        Context context = new Context();
        context.setStrategy(discountCalculatorStrategy);
        context.execute();
    }

    public interface DiscountCalculatorStrategy {
        void execute();
    }

    public static class DiscountCalculatorStrategyA implements DiscountCalculatorStrategy {

        public void execute() {
            System.out.println("优惠计价A的计算逻辑");
        }
    }

    public static class DiscountCalculatorStrategyB implements DiscountCalculatorStrategy {

        public void execute() {
            System.out.println("优惠计价B的计算逻辑");
        }
    }

    public static class DiscountCalculatorStrategyC implements DiscountCalculatorStrategy {

        public void execute() {
            System.out.println("优惠计价C的计算逻辑");
        }
    }

    public static class DiscountCalculatorStrategyDefault implements DiscountCalculatorStrategy {

        public void execute() {
            System.out.println("优惠计价默认的计算逻辑");
        }
    }

    public static class DiscountCalculatorStrategyFactory {
        public static DiscountCalculatorStrategy getDiscountCalculatorStrategy(int strategy) {
            if(strategy == 1) {
                return new DiscountCalculatorStrategyA();
            } else if(strategy == 2) {
                return new DiscountCalculatorStrategyB();
            } else if(strategy == 3) {
                return new DiscountCalculatorStrategyC();
            } else {
                return new DiscountCalculatorStrategyDefault();
            }
        }
    }

    public static class Context {
        private DiscountCalculatorStrategy strategy;

        public DiscountCalculatorStrategy getStrategy() {
            return strategy;
        }

        public void setStrategy(DiscountCalculatorStrategy strategy) {
            this.strategy = strategy;
        }

        public void execute() {
            strategy.execute();
        }
    }
}
