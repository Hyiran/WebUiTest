package webtest.core.page_ejj.mendianduanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;

import java.util.List;

/**
 * Created by Administrator on 2016-05-18.
 */
public class LookAllShopPage extends Page {
    /**
     * 页面标题  页面标题
     */
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;
    @FindBy(xpath = "/html/body")
    public WebElement body;

    /**
     * 搜索
     * searchShopName:搜索门店名字输入框
     * buttons：所有按钮的List集合
     */
    @FindBy(id = "shopsearch-name")
    public WebElement searchShopName;
    @FindBy(xpath = "//button")
    public List<WebElement> buttons;

    /**
     * 第一个门店的信息
     */
    @FindBy(xpath = "//*[@id=\"w2-container\"]/div/table/tbody/tr[1]/td[2]/a")
    public WebElement firstShopName;
    @FindBy(xpath = "//*[@id=\"w2-container\"]/div/table/tbody/tr[1]/td[5]")
    public WebElement firstShopPhone;
}
