package state;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 14:44
 * @description：状态模式
 * @modified By：
 * @version: 1.1
 */
public class UseStatePattern {
    public static void main(String[] args) {
        Context context = new Context(new NewState());
        context.execute(1);
        context.execute(2);
        context.execute(3);
    }

    public interface State {
        void execute();
    }

    public static class NewState implements State {

        public void execute() {
            System.out.println("执行销售出库单新建状态的逻辑");
        }
    }

    public static class ApproveState implements State {

        public void execute() {
            System.out.println("执行销售出库单待审核状态的逻辑");
        }
    }

    public static class ApprovedState implements State {

        public void execute() {
            System.out.println("执行销售出库单已审核状态的逻辑");
        }
    }

    public static class FinishedState implements State {

        public void execute() {
            System.out.println("执行销售出库单完成状态的逻辑");
        }
    }

    public static class Context {
        private State state;

        public Context(State state) {
            this.state = state;
            this.state.execute();
        }

        public void execute(int stateType) {
            if(stateType == 1) {
                this.state = new ApproveState();
                this.state.execute();
            } else if(stateType == 2) {
                this.state = new ApprovedState();
                this.state.execute();
            } else if(stateType == 3) {
                this.state = new FinishedState();
                this.state.execute();
            }
        }
    }
}
