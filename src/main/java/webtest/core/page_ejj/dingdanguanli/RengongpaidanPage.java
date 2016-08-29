package webtest.core.page_ejj.dingdanguanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;

/**
 * Created by Administrator on 2016-04-25.
 * 人工派单页面
 */
public class RengongpaidanPage extends Page {
    //页面标题
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;

    /**
     * 订单编号
     */
    @FindBy(id = "order_code")
    public WebElement orderCode;

    /**
     * 搜索阿姨
     * searchInput输入框
     * searchButton搜索按钮
     * cannotAssignButton无法指派按钮
     */
    @FindBy(id = "worker_search_input")
    public WebElement searchInput;
    @FindBy(id = "worker_search_submit")
    public WebElement searchButton;
    @FindBy(id = "can_not_assign")
    public WebElement cannotAssignButton;

    /**
     * 阿姨信息列表第一个阿姨
     * ayiNameFirst阿姨姓名
     * ayibiaoqian:阿姨标签
     * jiedianzhuangtai：阿姨状态
     * ayibeizhu：阿姨备注
     * paidanButton:派单按钮
     * judanButton:拒单按钮
     * weijietongButton：未接通按钮
     * beizu：备注按钮
     */
    @FindBy(xpath = "//*[@id=\"worker_list\"]/tbody/tr[1]/td[1]")
    public WebElement ayiNameFirst;
    @FindBy(xpath = "//*[@id=\"worker_list\"]/tbody/tr[1]/td[8]")
    public WebElement ayibiaoqian;
    @FindBy(xpath = "//*[@id=\"worker_list\"]/tbody/tr[1]/td[9]")
    public WebElement jiedianzhuangtai;
    @FindBy(xpath = "//*[@id=\"worker_list\"]/tbody/tr[1]/td[10]")
    public WebElement ayibeizhu;
    @FindBy(xpath = "//*[@id=\"worker_list\"]/tbody/tr[1]/td[11]/a[1]")
    public WebElement paidanButton;
    @FindBy(xpath = "//*[@id=\"worker_list\"]/tbody/tr[1]/td[11]/a[2]")
    public WebElement judanButton;
    @FindBy(xpath = "//*[@id=\"worker_list\"]/tbody/tr[1]/td[11]/a[3]")
    public WebElement weijietongButton;
    @FindBy(xpath = "//*[@id=\"worker_list\"]/tbody/tr[1]/td[11]/a[4]")
    public WebElement beizu;

    /**
     * 备注信息
     * tanchubeizhu:备注信息弹出框
     * beizhuInput输入框
     * beizhuButtonYes:确定按钮
     */
    @FindBy(id = "worker_remark")
    public WebElement tanchubeizhu;
    @FindBy(id = "worker_remark_memo")
    public WebElement beizhuInput;
    @FindBy(id = "worker_remark_submit")
    public WebElement beizhuButtonYes;
}
