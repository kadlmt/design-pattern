package proxy;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 11:01
 * @description：代理模式
 * @modified By：
 * @version: 1.1
 */
public class UseProxyPattern {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        Proxy proxy = new Proxy(concreteSubject);
        proxy.execute();
    }

    public interface Subject {
        void execute();
    }

    public static class ConcreteSubject implements Subject {

        public void execute() {
            System.out.println("执行请求");
        }
    }

    public static class Proxy implements Subject {
        private Subject subject;

        public Proxy(Subject subject) {
            this.subject = subject;
        }

        public void execute() {
            System.out.println("增强前");
            subject.execute();
            System.out.println("增强后");
        }
    }
}
