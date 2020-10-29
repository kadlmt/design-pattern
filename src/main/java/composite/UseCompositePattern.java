package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：liumt
 * @date ：Created in 2020/10/29 11:46
 * @description：组合模式
 * @modified By：
 * @version: 1.1
 */
public class UseCompositePattern {
    public static void main(String[] args) {
        Department leafDept1 = new Department("叶子部门1");
        Department leafDept2 = new Department("叶子部门2");
        Department leafDept3 = new Department("叶子部门3");

        Department subDept1 = new Department("子部门1");
        subDept1.getChildren().add(leafDept1);
        subDept1.getChildren().add(leafDept2);

        Department subDept2 = new Department("子部门2");
        subDept2.getChildren().add(leafDept3);

        Department parentDept = new Department("父部门");
        parentDept.getChildren().add(subDept1);
        parentDept.getChildren().add(subDept2);

        parentDept.remove();

        // 组合模式的第一要义，就是将树形结构的数据，用一个类，或者少数一两个类，就可以拼装成一棵树的形状
        // 组合模式的第二要义，就是直接对一个父级的数据执行某个操作，这个操作会直接递归调用所有下层的子数据的相关操作
        // 通过这个树形结构自己递归自己的方式，就将对一棵树的操作，完美的执行了
        // 好处，就是对树形数据的操作，不需要调用方组织复杂的屎一样的if for的代码，去执行
        // 外部要操作一颗树，直接对树的父级节点，调用一个操作，这颗树自己就递归着把事儿给干完了

        // 设计模式，重点，是思想，理解了思想，随便招式你怎么出，只要能将思想运用到实际业务场景中
        // 避免写出屎一样的代码，你就成功了
        // 如果你照搬设计模式去写，反而增加代码的复杂度
    }

    public static class Department {
        private String name;
        private List<Department> children = new ArrayList<Department>();

        public Department(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Department> getChildren() {
            return children;
        }

        public void setChildren(List<Department> children) {
            this.children = children;
        }

        public void remove() {
            if(children != null) {
                for(int i = 0; i < children.size(); i++){
                    children.get(i).remove();
                }
            }
            children = null;
        }
    }
}
