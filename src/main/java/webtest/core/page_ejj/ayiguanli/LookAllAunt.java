package webtest.core.page_ejj.ayiguanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;

import java.util.List;

/**
 * Created by Administrator on 2016-06-06.
 * 查看所有阿姨页面
 */
public class LookAllAunt extends Page {
    /**
     * 所有的link
     */
    @FindBy(xpath = "//a[@style='margin-left: 10px;']")
    public List<WebElement> links;

    //body
    @FindBy(xpath = "/html/body")
    public WebElement body;
    /**
     * 搜索
     */
    @FindBy(id = "workersearch-worker_name")
    public WebElement search_name;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement search_button;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public List<WebElement> a_button;

    //阿姨姓名
    @FindBy(xpath = "//a[@style='margin-right:5%']")
    public List<WebElement> ayinames;
    /**
     * 阿姨管理
     */
    @FindBy(xpath = "//label[@class='radio-inline']")
    public List<WebElement> lables;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement button;

    //确认上岗
    @FindBy(xpath = "//button[@class='btn btn-info btn-sm']")
    public WebElement sue_but;

    //订单状态
    @FindBy(xpath = "//td[@data-col-seq='8']")
    public WebElement order_status;
}
