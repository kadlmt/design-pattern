package dynamic;

/**
 * @author ：liumt
 * @date ：Created in 2020/8/11 22:01
 * @description：
 * @modified By：
 * @version: 1.1
 */
public class Test {
    public static void main(String[] args){
        BbFactory b = new ManToolFactory();
        LisonFactory lisonFactory = new LisonFactory();
        lisonFactory.setFactory(b);
        BbFactory bbFactory = (BbFactory) lisonFactory.getInstance();
        bbFactory.saleTool();
    }
}
