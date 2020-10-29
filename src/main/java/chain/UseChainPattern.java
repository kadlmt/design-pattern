package chain;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 17:05
 * @description：责任链模式
 * @modified By：
 * @version: 1.1
 */
public class UseChainPattern {
    public static void main(String[] args) {
        // 业务流程1
        Handle thirdHandler = new HandleC(null);
        Handle secondHandler = new HandleB(thirdHandler);
        Handle firstHandler = new HandleA(secondHandler);
        firstHandler.execute();

        // 业务流程2
        thirdHandler = new HandleC(null);
        secondHandler = new HandleA(thirdHandler);
        firstHandler = new HandleB(secondHandler);
        firstHandler.execute();

        // 责任链的思想
        // 1：将一个业务流程中的多个步骤拆分开来，每个步骤封装到一个handler处理器中去
        // 2：支持业务流程基于handler动态组装，不同的业务流程 -> handler代表的代码组件可以复用

        // 好处1：将这个代码封装到一个handler中，后面如果要对某个步骤的代码逻辑调整，修改一个handler即可
        // 好处2：如果业务流程要修改，那么不需要拷贝大量的代码，只要基于handler动态组装业务流程即可

        // 面向的场景
        // 就是有多个业务流程，这些业务流程之间有相同的代码逻辑和步骤
        // 可以用责任链模式来实现
    }

    public static abstract class Handle {
        protected Handle successor;

        public Handle(Handle successor) {
            this.successor = successor;
        }

        public abstract void execute();
    }

    public static class HandleA extends Handle {
        public HandleA(Handle successor) {
            super(successor);
        }

        @Override
        public void execute() {
            System.out.println("执行功能1");
            if(successor != null) {
                successor.execute();
            }
        }
    }

    public static class HandleB extends Handle {
        public HandleB(Handle successor) {
            super(successor);
        }

        @Override
        public void execute() {
            System.out.println("执行功能2");
            if(successor != null) {
                successor.execute();
            }
        }
    }

    public static class HandleC extends Handle {
        public HandleC(Handle successor) {
            super(successor);
        }

        @Override
        public void execute() {
            System.out.println("执行功能3");
            if(successor != null) {
                successor.execute();
            }
        }
    }
}
