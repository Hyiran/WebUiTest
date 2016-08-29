package webtest.core.page_ejj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import webtest.core.Page;

import java.util.List;

public class HomePage extends Page{

    //用户名
    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/div[1]/div[2]/p[1]")
    public WebElement userName;

    //body
    @FindBy(xpath = "/html/body")
    public WebElement body;

    /**
     * E家洁图标按钮
     * 功能点击返回首页
     */
    @FindBy(xpath = "/html/body/header/a")
    public WebElement backHome;

    //查看所有家政公司
    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/ul/li[1]/ul/li[1]/a")
    public WebElement lookAll_jiazhenggongshi;

    //添加新家政
    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/ul/li[1]/ul/li[2]/a")
    public WebElement addNew_jiazheng;

    //查看所有门店
    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/ul/li[2]/ul/li[1]/a")
    public WebElement lookAll_mendian;

    //添加新门店
    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/ul/li[2]/ul/li[2]/a")
    public WebElement add_mendian;

    //查看所有服务供应商
    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/ul/li[3]/ul/li[1]/a")
    public WebElement lookAll_fuwugongyinghsang;

    //录入新供应商
    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/ul/li[3]/ul/li[2]/a")
    public WebElement add_gongyingshang;

    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/ul/li[4]/ul/li[2]/a")
    public WebElement add_NewAunt;

    //查看所有订单
    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/ul/li[6]/ul/li[1]/a")
    public WebElement lookAllOrder;

    //人工下单
    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/ul/li[6]/ul/li[4]/a")
    public WebElement humenMakeOrder;

    //退款审核
    @FindBy(xpath = "/html/body/div[2]/aside[1]/div/section/ul/li[9]/ul/li[3]/ul/li[1]/a")
    public WebElement tuikuanshenhe;

    /**
     * 所有的链接
     */
    @FindBy(xpath = "//a[@style = 'margin-left: 10px;']")
    public List<WebElement> LinkAll;


}
