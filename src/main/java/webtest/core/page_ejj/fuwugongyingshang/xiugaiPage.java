package webtest.core.page_ejj.fuwugongyingshang;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;

import java.util.List;

/**
 * Created by Administrator on 2016-05-26.
 */
public class xiugaiPage extends Page {
    /**
     * 订单创建成功页面标题订单号
     */
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement orderCode;

    /**
     * body
     */
    @FindBy(xpath = "/html/body")
    public WebElement body;

    /**
     * 所有的服务供应商信息
     *
     */
    @FindBy(xpath = "//div[@class='kv-attribute']")
    public List<WebElement> divs;


}
