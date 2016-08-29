package webtest.core.page_ejj.fuwugongyingshang;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;

/**
 * Created by Administrator on 2016-05-24.
 * 查看所有服务供应商页面
 */
public class LookAllSupplierPage extends Page {
    /**
     * pageText :当前页面的标题
     */
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;

}
