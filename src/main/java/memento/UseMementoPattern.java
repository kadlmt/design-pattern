package memento;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 15:08
 * @description：备忘录模式
 * @modified By：
 * @version: 1.1
 */
public class UseMementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.prepare("中间数据");
        //创建备忘录
        Memento memento = originator.createMemento();
        originator.executeA();
        //恢复备忘录
        originator.setMemento(memento);
        originator.executeB();
    }

    public interface Memento {

    }

    public static class Originator {
        private String state;

        public void prepare(String state) {
            this.state = state;
        }

        public void executeA() {
            System.out.println("基于中间数据【" + state +"】执行了A方法的逻辑");
            // 将state所代表的中间数据做出了修改
            state += "，A方法的结果数据";
        }

        public void executeB() {
            System.out.println("基于中间数据【" + state +"】执行了B方法的逻辑");
            // 将state所代表的中间数据做出了修改
            state += "，B方法的结果数据";
        }

        public Memento createMemento() {
            return new MementoImpl(this.state);
        }

        public void setMemento(Memento memento){
            MementoImpl mementoImpl = (MementoImpl) memento;
            this.state = mementoImpl.getState();
        }

        public static class MementoImpl implements Memento {
            private String state;

            public MementoImpl(String state) {
                this.state = state;
            }

            public String getState() {
                return state;
            }
        }
    }
}
