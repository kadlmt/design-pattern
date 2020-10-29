package decorator;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 16:42
 * @description：装饰器模式
 * @modified By：
 * @version: 1.1
 */
public class UseDecoratorPattern {
    public static void main(String[] args) {
        Component component = new Decorator(new ConcreteComponent());
        component.execute();
    }

    public interface Component {
        void execute();
    }

    public static class ConcreteComponent implements Component {

        @Override
        public void execute() {
            System.out.println("执行基础功能");
        }
    }

    public static class Decorator implements Component {
        private Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void execute() {
            System.out.println("在执行基础功能之前，执行部分功能增强");
            component.execute();
            System.out.println("在执行基础功能之后，执行部分功能增强");
        }
    }
}
