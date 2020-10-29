package observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 11:17
 * @description：观察者模式
 * @modified By：
 * @version: 1.1
 */
public class UseObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject("0");
        Observer observer = new ConcreteSubject();
        subject.addObserver(observer);

        subject.setState("1");
    }

    public static class Subject extends Observable {
        private String state;

        public Subject(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
            //通知观察者
            this.setChanged();
            this.notifyObservers(state);
        }
    }

    public static class ConcreteSubject implements Observer {

        public void update(Observable o, Object arg) {
            System.out.println("目标对象发生变化->" + arg);
        }
    }
}
