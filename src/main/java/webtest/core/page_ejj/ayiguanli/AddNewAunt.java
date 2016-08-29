package webtest.core.page_ejj.ayiguanli;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webtest.core.Page;

import java.util.List;

/**
 * Created by Administrator on 2016-05-27.
 * 录入新阿姨
 */
public class AddNewAunt extends Page{
    /**
     * pageText :当前页面的标题
     */
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;

    /**
     * body
     */
    @FindBy(xpath = "/html/body")
    public WebElement body;
    /**
     * 所有的input
     */
    @FindBy(xpath = "//input[@class='form-control']")
    public List<WebElement> inputs;

    /**
     * 所有的span下拉选（非select）
     */
    @FindBy(xpath = "//span[@aria-labelledby='select2-worker-worker_work_city-container']")
    public WebElement chenghsi;
    @FindBy(xpath = "//span[@aria-labelledby='select2-worker-shop_id-container']")
    public WebElement mendian;
    @FindBy(xpath = "//span[@aria-labelledby='select2-workerext-worker_source-container']")
    public WebElement laiyuan;
    @FindBy(xpath = "//span[@aria-labelledby='select2-workerext-worker_edu-container']")
    public WebElement jiaoyuchengdu;
    @FindBy(xpath = "//span[@aria-labelledby='select2-workerinsurancerelation-worker_insurance_id-container']")
    public WebElement jiaonafangshi;
    @FindBy(xpath = "//span[@aria-labelledby='select2-worker-worker_identity_id-container']")
    public WebElement ayishenfen;
    @FindBy(xpath = "//span[@aria-labelledby='select2-workerext-worker_live_province-container']")
    public WebElement juzhudi_sheng;
    @FindBy(xpath = "//span[@aria-labelledby='select2-workerext-worker_live_city-container']")
    public WebElement juzhudi_shi;
    @FindBy(xpath = "//span[@aria-labelledby='select2-workerext-worker_live_area-container']")
    public WebElement juzhudi_xian;


    /**
     * 所有的隐藏li标签
     * 所有的家政公司（归属家政公司选择的下拉选项）
     * 所有的银行，选择银行的下拉选项
     */
    @FindBy(xpath = "//li[@role='treeitem']")
    public List<WebElement> AllLi;

    /**
     * 阿姨头像
     */
    @FindBy(id = "worker-worker_photo")
    public WebElement ayitouxiang;

    /**
     * 下拉选非select、非span
     */
    @FindBy(xpath = "//input[@class='select2-search__field']")
    public List<WebElement> selects;

    /**
     * 保险缴纳起止时间
     */
    @FindBy(id = "workerinsurancerelation-worker_insurance_start_time")
    public WebElement startTime;
    @FindBy(id = "workerinsurancerelation-worker_insurance_end_time")
    public WebElement endTime;

    /**
     * 创建按钮
     */
    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement createButton;

    /**
     * 排班表保存页面
     */
    @FindBy(id = "w4-container")
    public WebElement div;
    @FindBy(xpath = "//span[@class='form-control text-right']")
    public WebElement shijiankongjian;

    //开始时间、结束时间
    @FindBy(xpath = "//input[@name='daterangepicker_start']")
    public WebElement paibanStartTime;
    @FindBy(xpath = "//input[@name='daterangepicker_end']")
    public WebElement paibanEndTime;

    //选择按钮
    @FindBy(xpath = "//button[@class='applyBtn btn btn-small btn-sm btn-success']")
    public WebElement chooseButton;
    //保存排班表按钮
    @FindBy(id = "btn-submit")
    public WebElement savepaibanbiao;
    //排班表某个字段
    @FindBy(xpath = "//*[@id=\"schedule-list\"]/div/div[2]/table/tbody/tr[1]/th[1]")
    public WebElement paibanbiaoSome;
}
