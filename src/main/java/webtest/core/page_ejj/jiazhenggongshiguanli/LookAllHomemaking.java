package webtest.core.page_ejj.jiazhenggongshiguanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import webtest.core.Page;

public class LookAllHomemaking extends Page{

    //页面标题
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;
}

