package command;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 11:28
 * @description：命令模式
 * @modified By：
 * @version: 1.1
 */
public class UseCommandPattern {
    public static void main(String[] args) {
        CommandA commandA = new CommandA();
        CommandB commandB = new CommandB();
        Invoker invoker = new Invoker();

        invoker.setCommand(commandA);
        invoker.execute();

        invoker.setCommand(commandB);
        invoker.execute();
        // 有两种请求要发送过来执行
        // 一种请求是读请求，一种请求是写请求，不同请求要执行的功能逻辑是不一样的
        // 此时就非常适合用这个命令模式
        // 将读请求的功能逻辑封装到ReadCommand里面去，将写请求的功能逻辑封装到WriteCommand里面去
        // 然后设置一个通用的一个命令执行的类
        // 读请求来了，就封装ReadCommand，交给同一个命令执行类来执行即可
        // 写请求来了，就封装WriteCommand，交给同一个命令感知性类来执行即可
    }

    public interface Command {
        void execute();
    }

    public static class CommandA implements Command {

        public void execute() {
            System.out.println("执行命令A");
        }
    }

    public static class CommandB implements Command {

        public void execute() {
            System.out.println("执行命令B");
        }
    }

    public static class Invoker {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void execute() {
            System.out.println("其他逻辑1");
            command.execute();
            System.out.println("其他逻辑2");
        }
    }
}
