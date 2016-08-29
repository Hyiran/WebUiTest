package webtest.core.page_ejj.caiwuguanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;

/**
 * Created by Administrator on 2016-04-15.
 * 退款审核页面
 */
public class RefundAuditPage extends Page{

    /**
     * 页面标题
     */
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;

    /**
     * 查询模块
     * orderCodeInput:订单号查询输入框
     * searchButton:搜索按钮
     */
    @FindBy(id = "financerefundsearch-finance_refund_pay_flow_num")
    public WebElement orderCodeInput_search;
    @FindBy(id = "search")
    public WebElement searchButton;

    /**
     * 订单列表DIV
     * firstOrderCode第一个订单的订单号
     * chakanButton查看按钮
     * shenhetongguoButton审核通过按钮
     */
    @FindBy(xpath = "//*[@id=\"w2-container\"]/div/table/tbody/tr/td[2]/a/i")
    public WebElement firstOrderCode;
    @FindBy(xpath = "//*[@id=\"w2-container\"]/div/table/tbody/tr[1]/td[7]")
    public WebElement orderMoney;
    //String s[] = ddq.getText().split("\\.");
    //public String orderMoney = s[0];
    @FindBy(xpath = "//*[@id=\"w2-container\"]/div/table/tbody/tr/td[19]/a[1]/span")
    public WebElement chakanButton;
    @FindBy(xpath = "//*[@id=\"w2-container\"]/div/table/tbody/tr/td[19]/a[2]/span")
    public WebElement shenhetongguoButton;

}
