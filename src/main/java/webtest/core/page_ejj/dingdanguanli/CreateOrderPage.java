package webtest.core.page_ejj.dingdanguanli;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import webtest.core.Page;

import java.util.List;

public class CreateOrderPage extends Page{
    /**
     * pageText :当前页面的标题
     */
    @FindBy(xpath = "/html/body/div[2]/aside[2]/section[1]/h1")
    public WebElement pageText;


    /**
     * 页面body
     */
    @FindBy(xpath = "/html/body")
    public WebElement body;

    /**
     * phoneNumber:手机号输入框ID
     * phoneBody:手机号输入框Body
     * fuwuxinxiDiV:服务信息的标题DIV
     */
    @FindBy(id = "order-order_customer_phone")
    public WebElement phoneNumber;
    @FindBy(xpath = "//*[@id=\"order_create_form\"]/div/div[2]/div[1]")
    public WebElement phoneDiv;
    @FindBy(xpath = "//*[@id=\"order_create_form\"]/div/div[1]")
    public WebElement kehuxinxiDiV;

    /**
     * 用户的第一个地址
     * addressOne:第一个地址
     * addressOneButton：第一个地址的编辑按钮
     * addressOneInput:第一个地址的input单选框
     */

    @FindBy(xpath="//*[@id='order-address_id']/div[1]")
    public WebElement addressOne;
    public String addressOne_xpath = "//*[@id='order-address_id']/div[1]";

    @FindBy(xpath = "//*[@id='order-address_id']/div[1]/button")
    public WebElement addressOneButton;

    @FindBy(xpath = "//*[@id='order-address_id']/div[1]/label[1]")
    public WebElement addressOneInput;
    public String addressOneInput_xpath = "//*[@id='order-address_id']/div[1]/label[1]";

    /**
     * 用户下单地址添加
     *  sheng:选择省份select
     *  shi：选择城市select
     *  xian:选择县区select
     *  xiangxi:详细信息输入框
     *  baocun:保存按钮
     */
    @FindBy(xpath = "//*[@id=\"order-address_id\"]/div[1]/div[1]/select")
    public WebElement sheng;

    @FindBy(xpath = "//*[@id=\"order-address_id\"]/div[1]/div[2]/select")
    public WebElement shi;

    @FindBy(xpath = "//*[@id=\"order-address_id\"]/div[1]/div[3]/select")
    public WebElement xian;

    @FindBy(xpath = "//*[@id=\"order-address_id\"]/div[1]/div[4]/input")
    public WebElement xiangxi;

    @FindBy(xpath = "//*[@id=\"order-address_id\"]/div[1]/div[7]/button[1]")
    public  WebElement baocun;


    //家庭保洁选择
    @FindBy(xpath="//*[@id='order-order_service_item_id']/label[1]/input")
    public WebElement bjrw_click_xpath;

    //要指定阿姨姓名、手机号搜索
    @FindBy(id="worker_name_search")
    public WebElement ayiname_text_id;

    //服务信息DIV
    @FindBy(xpath="//*[@id='order_create_form']/div/div[4]")
    WebElement serverMessage_div_xpath;

    //搜索出来阿姨信息的div_ID
    @FindBy(id="order-order_booked_worker_id")
    WebElement zhidingayi_div_id;

    /**
     *  rili_input_id:日历控件
     *  serviceTimeOne：服务时长第一个
     *  serviceTimeTwo：服务时长第二个
     *  fuwushijianduan：服务时间段第一个
     */
    @FindBy(id="order-orderbookeddate")
    public WebElement rili_input_id;

    @FindBy(xpath = "//*[@id=\"order-order_booked_count\"]/label[1]/input")
    public WebElement serviceTimeOne;

    @FindBy(xpath = "//*[@id=\"order-order_booked_count\"]/label[2]")
    public WebElement serviceTimeTwo;

    @FindBy(xpath = "//*[@id=\"order-orderbookedtimerange\"]/label[1]/input")
    public WebElement fuwushijianduan;
    //public String fuwushijianduanFrist = "//*[@id=\"order-orderbookedtimerange\"]/label[3]/input";

    /**
     * 支付方式
     * xianjinzhifu:现金支付
     * yuezhifu：余额支付
     */
    @FindBy(xpath = "//*[@id='order-pay_channel_id']/label[1]/input")
    public WebElement xianjinzhifu;
    @FindBy(xpath = "//*[@id='order-pay_channel_id']/label[2]/input")
    public WebElement yuezhifu;

    /**
     * 是否系统指派
     * xitongzhipai_ture:系统指派是
     * xitongzhipai_false：系统指派否

    @FindBy(xpath = "//*[@id='order-order_flag_sys_assign']/label[1]/input")
    public WebElement xitongzhipai_ture;
    @FindBy(xpath = "//*[@id='order-order_flag_sys_assign']/label[2]/input")
    public WebElement xitongzhipai_false;
     */
    /**
     * 创建待指派订单
     */
    @FindBy(id = "submit_button_3")
    public WebElement chuangjiandaizhipaidingdan;

    //客户备注
    @FindBy(id="order-order_customer_memo")
    private WebElement khbz;

    //客服备注
    @FindBy(id="order-order_cs_memo")
    private WebElement kfbz;


    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> inputs;

}
