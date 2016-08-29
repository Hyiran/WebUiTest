package webtest.core.page_ejj.mendianduanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;

import java.util.List;

/**
 * Created by Administrator on 2016-05-16.
 * 添加新门店
 */
public class AddShopPage extends Page {

    //页面标题
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;

    /**
     * 基础信息
     * shopName:门店名字
     * 省份、城市、区县
     */
    @FindBy(id = "shop-name")
    public WebElement shopName;
    @FindBy(id = "province")
    public WebElement shengfen;
    @FindBy(id = "city")
    public WebElement chengshi;
    @FindBy(id = "county")
    public WebElement quxian;

    /**
     * 门店基础信息
     * 办公街道、归属家政公司、负责人、电话、其他联系方式
     */
    @FindBy(id = "shop-street")
    public WebElement jiedao;
    @FindBy(xpath = "//span[@aria-labelledby='select2-shop-shop_manager_id-container']")
    public WebElement guishujiazheng;
    @FindBy(id = "shop-principal")
    public WebElement fuzheren;
    @FindBy(id = "shop-tel")
    public WebElement dianhua;
    @FindBy(id = "shop-other_contact")
    public WebElement qitalianxi;
    /**
     * 所有的隐藏li标签
     * 所有的家政公司（归属家政公司选择的下拉选项）
     * 所有的银行，选择银行的下拉选项
     */
    @FindBy(xpath = "//li[@role='treeitem']")
    public List<WebElement> AllLi;

    /**
     * 银行信息
     * 开户行，支行名称、开户地址、开户人、银行卡号
     */
    @FindBy(xpath = "//span[@aria-labelledby='select2-shop-opening_bank-container']")
    public WebElement kaihuhang;
    @FindBy(id = "shop-sub_branch")
    public WebElement zhihangName;
    @FindBy(id = "shop-opening_address")
    public WebElement kaihuAddress;
    @FindBy(id = "shop-account_person")
    public WebElement kaihuren;
    @FindBy(id = "shop-bankcard_number")
    public WebElement yinhangkahao;

    /**
     * 创建按钮
     */
    @FindBy(xpath = "//button[@class='btn btn-success btn-lg btn-block']")
    public WebElement createButton;

}
