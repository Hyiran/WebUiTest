package webtest.core.page_ejj.dingdanguanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import webtest.core.Page;

/**
 * Created by Administrator on 2016-04-14.
 */
public class LookAllOrderPage extends Page {
    /**
     *  页面标题
     */
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;

    /**
     * 页面body
     */
    @FindBy(xpath = "/html/body")
    public WebElement body;

    /**
     * 订单列表LIST
     */
    @FindBy(id = "w1")
    public WebElement orderList;

    /**
     * 搜索模块
     * search_userPhoneNumber用户手机号输入框
     * search_ayiPhoneNumber阿姨手机号输入框
     * search_orderCode订单号输入框
     * searchButton搜索按钮
     */
    @FindBy(id = "ordersearchindex-order_customer_phone")
    public WebElement search_userPhoneNumber;

    @FindBy(id = "ordersearchindex-order_worker_phone")
    public WebElement search_ayiPhoneNumber;

    @FindBy(id = "ordersearchindex-order_code")
    public WebElement search_orderCode;

    @FindBy(xpath = "//*[@id=\"w0\"]/div[3]/div[3]/button")
    public WebElement searchButton;

    /**
     * 第一个订单的订单编号部分
     */
    @FindBy(xpath = "//*[@id=\"w1\"]/div[2]/div/table/tbody/tr[1]/th")
    private WebElement case1;
    String s1[] = this.case1.getText().split("        ");
    String orderCode[] = s1[0].split("：");
    public String firstOrderCode = orderCode[1];

    /**
     * 第一个订单的订单金额
     */
    @FindBy(xpath = "//*[@id=\"w1\"]/div[2]/div/table/tbody/tr[2]/td[2]")
    public WebElement case2;
    String all[] = case2.getText().split("\\n");
    String money[] = all[3].split("：");
    String mon[] = money[1].split("\\.");
    public String orderMoney = mon[0];

    /**
     * 接单阿姨姓名
     */
    @FindBy(xpath = "//*[@id=\"w1\"]/div[2]/div/table/tbody/tr[2]/td[3]/span[1]")
    public WebElement ayiName;

    /**
     * 第一个订单的操作按钮依次为
     * lookOrder:查看订单
     * complaint:投诉
     * cancelOrder:取消订单
     * assignedAunt:指派阿姨
     * sendMessages:发送短信
     */
    @FindBy(xpath = "//*[@id=\"w1\"]/div[2]/div/table/tbody/tr[2]/td[5]/p[1]/a")
    public WebElement lookOrder;
    @FindBy(xpath = "//*[@id=\"w1\"]/div[2]/div/table/tbody/tr[2]/td[5]/p[2]/a")
    public WebElement complaint;
    @FindBy(xpath = "//*[@id=\"w1\"]/div[2]/div/table/tbody/tr[2]/td[5]/p[3]/a")
    public WebElement cancelOrder;
    @FindBy(xpath = "//*[@id=\"w1\"]/div[2]/div/table/tbody/tr[2]/td[5]/p[4]/a")
    public WebElement assignedAunt;
    @FindBy(xpath = "//*[@id=\"w1\"]/div[2]/div/table/tbody/tr[2]/td[5]/p[5]/a")
    public WebElement sendMessages;

    /**
     * 取消订单弹出的form
     * formDIV页面：quxiaoform
     * 关闭form按钮：closeButton
     * 取消原因：kehuyuanyin客户原因；gongshiyuanyin公司原因
     * 具体原因：kehubuxuyao客户不需要;
     * 备注输入框：beizu
     * 确认提交按钮：querenanniu
     */
    @FindBy(id = "HBox")
    public WebElement quxiaoform;

    @FindBy(id = "HCloseBtn")
    public WebElement closeButton;

    @FindBy(xpath = "//*[@id=\"HBox\"]/form/ul/li[1]/div/label[1]/input")
    public WebElement kehuyuanyin;
    @FindBy(xpath = "//*[@id=\"HBox\"]/form/ul/li[1]/div/label[2]/input")
    public WebElement gongshiyuanyin;

    @FindBy(xpath = "//*[@id=\"HBox\"]/form/ul/li[2]/div[1]/label[2]/input")
    public WebElement kehubuxuyao;
    @FindBy(id = "text_CancelNote")
    public WebElement beizu;
    @FindBy(xpath = "//*[@id=\"HBox\"]/form/ul/li[4]/input")
    public WebElement querenanniu;
}
