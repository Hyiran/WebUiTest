package webtest.core.page_ejj.fuwugongyingshang;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;

import java.util.List;

/**
 * Created by Administrator on 2016-05-24.
 * 添加服务供应商页面
 */
public class AddSupplierPage extends Page{
    /**
     * pageText :当前页面的标题
     */
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;

    /**
     * 所有的class = form-control的
     * input输入框
     */
    @FindBy(xpath = "//input[@class='form-control']")
    public List<WebElement> inputs;

    /**
     * 所有的隐藏li标签
     * 所有的家政公司（归属家政公司选择的下拉选项）
     * 所有的银行，选择银行的下拉选项
     */
    @FindBy(xpath = "//li[@role='treeitem']")
    public List<WebElement> AllLi;

    /**
     * 所有的span下拉选（非select）
     */
    @FindBy(xpath = "//span[@aria-labelledby='select2-supplier-supplier_province-container']")
    public WebElement sheng;
    @FindBy(xpath = "//span[@aria-labelledby='select2-supplier-supplier_city-container']")
    public WebElement shi;
    @FindBy(xpath = "//span[@aria-labelledby='select2-supplier-supplier_area-container']")
    public WebElement xian;
    @FindBy(xpath = "//span[@aria-labelledby='select2-supplierext-supplier_business_registration_type-container']")
    public WebElement zhuceleixing;

    /**
     * 营业执照
     */
    @FindBy(id = "supplierext-supplier_business_licence_pic")
    public WebElement upload;

    /**
     * 两个时间控件
     * gongyingshangzhuceshijian：供应商注册日期
     * gongyingshangyouxiaoqi：供应商有效期
     * time_start：供应商有效期的开始时间
     * time_end：供应商有效期的结束时间
     * xuanzhe：选择按钮
     */
    @FindBy(id = "supplierext-supplier_business_registration_date")
    public WebElement gongyingshangzhuceshijian;
    @FindBy(id = "supplierext-supplier_business_validity_time-container")
    public WebElement gongyingshangyouxiaoqi;
    @FindBy(xpath = "//input[@name='daterangepicker_start']")
    public WebElement time_start;
    @FindBy(xpath = "//input[@name='daterangepicker_end']")
    public WebElement time_end;
    @FindBy(xpath = "//button[@class='applyBtn btn btn-small btn-sm btn-success']")
    public WebElement xuanzhe;

    /**
     * 创建按钮
     */
    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement createButton;

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
