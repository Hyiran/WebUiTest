package webtest.core.page_ejj.jiazhenggongshiguanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import webtest.core.Page;

import java.util.List;

public class AddNewHomemaking extends Page{

    //页面标题
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;

    /**
     * body
     */
    @FindBy(xpath = "/html/body")
    public WebElement body;

    /**
     * 家政公司基础信息
     * 名字、省份、城市、区县
     */
    @FindBy(id = "shopmanager-name")
    public WebElement jiazhengName;
    @FindBy(id = "province")
    public WebElement shengfen;
    @FindBy(id = "city")
    public WebElement chengshi;
    @FindBy(id = "county")
    public WebElement quxian;

    /**
     * 家政公司基础信息
     * 办公街道、负责人、电话、其他联系方式
     */
    @FindBy(id = "shopmanager-street")
    public WebElement jiedao;
    @FindBy(id = "shopmanager-principal")
    public WebElement fuzheren;
    @FindBy(id = "shopmanager-tel")
    public WebElement dianhua;
    @FindBy(id = "shopmanager-other_contact")
    public WebElement qitalianxi;

    /**
     * 家政公司营业执照息
     * 营业执照名称、营业地址、注册类型、法人代表、注册号
     */
    @FindBy(id = "shopmanager-bl_name")
    public WebElement yingyezhizhaoName;
    @FindBy(id = "shopmanager-bl_address")
    public WebElement yingyeAddr;
    @FindBy(id = "shopmanager-bl_type")
    public WebElement zhuceleixing;
    @FindBy(id = "shopmanager-bl_person")
    public WebElement farendaibiao;
    @FindBy(id = "shopmanager-bl_number")
    public WebElement zhucehao;

    /**
     * 家政公司营业执照息
     * 注册时间、有效期起始时间、有效期结束时间、注册资本、营业执照URL、营业范围
     */
    @FindBy(id = "shopmanager-bl_create_time-disp")
    public WebElement zhuceTime;
    @FindBy(id = "shopmanager-bl_expiry_start-disp")
    public WebElement youxiaokaishi;
    @FindBy(id = "shopmanager-bl_expiry_end-disp")
    public WebElement youxiaojieshu;
    @FindBy(id = "shopmanager-bl_audit")
    public WebElement zhuceziben;
    @FindBy(id = "shopmanager-bl_photo_url")
    public WebElement yingyezhizhaoURL;
    @FindBy(id = "shopmanager-bl_business")
    public WebElement yingyefanwei;

    /**
     * 创建按钮
     */
    @FindBy(xpath = "//*[@id=\"w0\"]/div/div[5]/div/div/button")
    public WebElement chaungjianButton;

    /**
     * 创建成功家政信息信息
     */
    @FindBy(xpath = "//div[@class='kv-attribute']")
    public List<WebElement> managers;
}
