package cases;
import org.testng.annotations.Test;
/**
 * Created by han on 2016/3/21.
 */
public class DemoTest{

    @Test
    public void case1() {
        String s = "订单总额：50.00元";
        String s1[] = s.split("：");
        String s2[] = s1[1].split("\\.");
        for(int i =0 ; i<s2.length;i++) {
            System.out.println(s2[i]+"No." + (i+1));
        }

    }
}
