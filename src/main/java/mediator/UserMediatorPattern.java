package mediator;

import facade.FacadePattern;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 10:34
 * @description：中介者模式
 * @modified By：
 * @version: 1.1
 */
public class UserMediatorPattern {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();

        ModuleA moduleA = new ModuleA(mediator);
        ModuleB moduleB = new ModuleB(mediator);
        ModuleC moduleC = new ModuleC(mediator);

        moduleA.execute();
        moduleB.execute();
        moduleC.execute();

        // 好处在哪儿
        // moduleA，只要知道一个中介者就可以了，具体跟其他模块的交互都封装在中介者里面了
        // moduleB，同上
        // moduleC，同上
        // moduleA、B、C之间不再有任何的耦合，不再有复杂的交互关系，互相之间修改不会对对方产生什么影响
    }

    public static class Mediator {
        private ModuleA moduleA;
        private ModuleB moduleB;
        private ModuleC moduleC;

        public ModuleA getModuleA() {
            return moduleA;
        }

        public void setModuleA(ModuleA moduleA) {
            this.moduleA = moduleA;
        }

        public ModuleB getModuleB() {
            return moduleB;
        }

        public void setModuleB(ModuleB moduleB) {
            this.moduleB = moduleB;
        }

        public ModuleC getModuleC() {
            return moduleC;
        }

        public void setModuleC(ModuleC moduleC) {
            this.moduleC = moduleC;
        }
        
        public void invokeModuleA() {
            moduleB.execute("模块A通知中介者,");
            moduleC.execute("模块A通知中介者,");
        }

        public void invokeModuleB() {
            moduleA.execute("模块B通知中介者,");
            moduleC.execute("模块B通知中介者,");
        }

        public void invokeModuleC() {
            moduleB.execute("模块C通知中介者,");
            moduleA.execute("模块C通知中介者,");
        }
    }

    public static class ModuleA {
        private Mediator mediator;

        public ModuleA(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleA(this);
        }

        public void execute() {
            mediator.invokeModuleA();
        }
        
        public void execute(String value) {
            System.out.println(value + "调用模块A的功能");
        }
    }

    public static class ModuleB {
        private Mediator mediator;

        public ModuleB(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleB(this);
        }

        public void execute() {
            mediator.invokeModuleB();
        }

        public void execute(String value) {
            System.out.println(value + "调用模块B的功能");
        }
    }

    public static class ModuleC {
        private Mediator mediator;

        public ModuleC(Mediator mediator) {
            this.mediator = mediator;
            mediator.setModuleC(this);
        }

        public void execute() {
            mediator.invokeModuleC();
        }

        public void execute(String value) {
            System.out.println(value + "调用模块C的功能");
        }
    }
}
