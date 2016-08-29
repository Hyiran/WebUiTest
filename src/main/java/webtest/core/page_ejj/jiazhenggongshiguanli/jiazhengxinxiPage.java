package webtest.core.page_ejj.jiazhenggongshiguanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import webtest.core.Page;

import java.util.List;

/**
 * Created by Administrator on 2016-05-12.
 * 查看家政公司信息
 */
public class jiazhengxinxiPage extends Page {
    /**
     *
     */
    @FindBy(xpath = "//div[@class='kv-attribute']")
    public List<WebElement> managers;

    @FindBy(xpath = "/html/body")
    public WebElement body;
}
