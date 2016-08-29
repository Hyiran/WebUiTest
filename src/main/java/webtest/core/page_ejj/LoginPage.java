package webtest.core.page_ejj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;
import webtest.core.util.Wait;

/**
 * Created by Administrator on 2016-04-06.
 */
public class LoginPage extends Page {
    Wait w = new Wait();

    //登录标题
    @FindBy(xpath = "//*[@id='list']/li[1]/h3")
    public WebElement loginText;

    @FindBy(id="loginform-username")
    public WebElement userName_text_id;

    @FindBy(id="loginform-password")
    public WebElement userPassword_text_id;

    @FindBy(xpath="//*[@id='list']/li[5]/button")
    public WebElement login_button_xpath;

    @FindBy(xpath="//*[@id='list']/li[5]/p/i")
    public WebElement rememberMe_xpath;

    @FindBy(xpath="//*[id='list']/li[5]/span/a")
    public WebElement lostPassword_link_xpath;

    @FindBy(xpath="//*[id='w0']/div/div/div[1]/div/span/a")
    public WebElement help_link_xpath;

    @FindBy(xpath="//*[@id='list']/li[4]/div/p")
    public WebElement yanzhengmaError_text_xpath;


    /**
     * 登录方法
     * @param uName 用户名
     * @param uPassword 密码
     */

    public void login(String uName,String uPassword) {
        userName_text_id.clear();
        userName_text_id.sendKeys(uName);
        userPassword_text_id.clear();
        userPassword_text_id.sendKeys(uPassword);
        //w.time(8);
        login_button_xpath.click();
    }
}
