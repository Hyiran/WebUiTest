package webtest.core.page_ejj.dingdanguanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;

/**
 * Created by Administrator on 2016-04-12.
 */
public class CreateOrderSuccessPage extends Page {
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
     * 创建新订单按钮
     */
    @FindBy(xpath = "//button[@class='btn btn-warning']")
    public WebElement createOrder;

    /**
     * 当前订单的下单地址
     */
    @FindBy(xpath = "//*[@id=\"w0\"]/div/div[3]/table/tbody/tr[10]/td/div")
    public WebElement orderAddress;
}
