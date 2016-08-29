package cases_ejj;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import webtest.core.TestCase;
import webtest.core.page_ejj.HomePage;
import webtest.core.page_ejj.LoginPage;
import webtest.core.util.Wait;

/**
 * Created by Administrator on 2016-04-06.
 */
public class LoginTest extends WebTest {
    Wait w = new Wait();

    @Test(dataProvider = "getData")
    public void login(String jg,String user,String passwd) {
        LoginPage lp = new LoginPage();
        lp.login(user,passwd);

        if(jg.equals(1) || jg.equals("登录成功")){
            jg = "登录成功";
            HomePage hp = new HomePage();
            w.waitElementAttribute(10,hp.body,"class","skin-blue fixed  pace-done");
            //w.reFresh(10, hp.userName);
            String[] s = hp.userName.getText().split(",");
            Assert.assertEquals(user, s[1]);
            Reporter.log("正确用户名密码测试登录成功通过");
        }else
        if(jg.equals(0) || jg.equals("登录失败")){
            Assert.assertEquals("登录", lp.loginText.getText());
            Reporter.log("错误用户名密码测试登录失败通过");
        }else {
            log.error("预期结果无法识别---" + jg);
            Reporter.log("预期结果无法识别---" + jg);
            Assert.assertEquals("1", "0");
        }

    }

}
