package cases_ejj.ayiguanli;

import cases_ejj.HomeLinkTest;
import cases_ejj.LoginTest;
import cases_ejj.NoMethodOpenBrowser;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webtest.core.page_ejj.ayiguanli.AddNewAunt;
import webtest.core.page_ejj.ayiguanli.LookAllAunt;
import webtest.core.util.Wait;
import webtest.core.util.getDate;

/**
 * Created by Administrator on 2016-06-01.
 */
public class AddAuntTest extends NoMethodOpenBrowser {
    Wait w = new Wait();
    /**
     * AYXM：阿姨的名称
     * 名称格式例:05月26日15:33:50
     * code:身份证号后8位
     */
    String date[] = getDate.getStringArrayDate();
    String scen[] = getDate.getStringArrayDateSceond();
    String dateSec = getDate.getDateSceond();
    String AYXM = date[1] + "月" + date[2] + "日" + dateSec;
    String code = date[2] + scen[0] + scen[1] + scen[2];

    /**
     * 获取时间
     * dateNow：当前日期
     * dateLast：当前时间减去五天
     * dateFuture：当前年份加上五年
     */
    int date1[] = getDate.getIntArrayDate();
    String dateNow = String.valueOf(date1[0]) + "-" + String.valueOf(date1[1]) + "-" + String.valueOf(date1[2]);
    int year = date1[0] + 5;
    String dateFuture = String.valueOf(year) + "/" + String.valueOf(date1[1]) + "/" + String.valueOf(date1[2]);
    /**
     * 前置条件，测试添加供应商需要先登录 并进入添加供应商
     * @param user 用户名
     * @param passwd 密码
     */
    @Parameters({"admin_user","admin_pass","index"})
    @Test(priority = 1)
    public void Login(String user,String passwd,String url) {
        //调用已有测试方法进行测试
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(url);
        LoginTest lt = new LoginTest();
        lt.login("登录成功", user, passwd);
        HomeLinkTest hlt = new HomeLinkTest();
        hlt.click_AddNewAunt();
    }

    /**
     * 基础信息1
     */
    @Test(priority = 2)
    public void BasicInformation1() {
        AddNewAunt ana = new AddNewAunt();
        ana.chenghsi.click();
        w.waitElementAttribute(10,ana.chenghsi,"aria-expanded","true");
        ana.reLoad();
        this.selectElement(ana.AllLi,"北京市").click();
        ana.mendian.click();
        w.waitElementAttribute(10,ana.mendian,"aria-expanded","true");
        w.time(1);
        ana.reLoad();
        this.selectElement(ana.AllLi,"测试门店").click();
        w.time(1);
        Reporter.log("阿姨基础信息录入成功输入成功");
    }
    /**
     * 基础信息2
     */
    @Test(priority = 3)
    public void BasicInformation2() {
        AddNewAunt ana = new AddNewAunt();
        ana.ayitouxiang.sendKeys("C:/Users/Public/Pictures/Sample Pictures/阿姨头像.jpg");
        w.time(1);
        ana.laiyuan.click();
        w.waitElementAttribute(10,ana.laiyuan,"aria-expanded","true");
        w.reFresh(10,selectElement(ana.AllLi,"蓝领招聘"));
        ana.reLoad();
        this.selectElement(ana.AllLi,"蓝领招聘").click();
        this.selectElementAttribute(ana.inputs,"placeholder","输入阿姨姓名...").sendKeys(AYXM);
        this.selectElementAttribute(ana.inputs,"placeholder","输入阿姨手机...").sendKeys("147" + code);
        this.selectElementAttribute(ana.inputs,"placeholder","输入阿姨身份证号...").sendKeys("10" + code + code);
        this.selectElementAttribute(ana.selects,"placeholder","选择阿姨商圈").click();
        w.waitElementAttribute(10,this.selectElementAttribute(ana.selects,"placeholder","选择阿姨商圈"),"tabindex","0");
        ana.reLoad();
        this.selectElement(ana.AllLi,"大悦城").click();
        this.selectElementAttribute(ana.inputs,"placeholder","输入阿姨身高...").sendKeys("165");
        ana.jiaoyuchengdu.click();
        w.waitElementAttribute(10,ana.jiaoyuchengdu,"aria-expanded","true");
        ana.reLoad();
        this.selectElement(ana.AllLi,"高中").click();
        this.selectElementAttribute(ana.inputs,"placeholder","输入阿姨籍贯...").sendKeys("河南");

    }
    /**
     * 基础信息3
     */
    @Test(priority = 4)
    public void BasicInformation3() {
        AddNewAunt ana = new AddNewAunt();
        //选择保险缴纳方式
        ana.jiaonafangshi.click();
        w.waitElementAttribute(10,ana.jiaonafangshi,"aria-expanded","true");
        w.reFresh(10,selectElement(ana.AllLi,"e家洁缴纳"));
        ana.reLoad();
        this.selectElement(ana.AllLi,"e家洁缴纳").click();
        //缴费金额
        this.selectElementAttribute(ana.inputs,"placeholder","输入缴纳金额...").sendKeys("5000");
        //缴费起止日期
        ana.startTime.sendKeys(dateNow);
        ana.endTime.sendKeys(dateFuture);
        //选择阿姨身份
        ana.ayishenfen.click();
        w.waitElementAttribute(10,ana.ayishenfen,"aria-expanded","true");
        w.reFresh(10,selectElement(ana.AllLi,"全时"));
        ana.reLoad();
        this.selectElement(ana.AllLi,"全时").click();
        //阿姨服务种类
        this.selectElementAttribute(ana.selects,"placeholder","选择阿姨种类").click();
        w.waitElementAttribute(10,this.selectElementAttribute(ana.selects,"placeholder","选择阿姨种类"),"tabindex","0");
        ana.reLoad();
        this.selectElement(ana.AllLi,"家庭保洁").click();
        //选择阿姨角色
        this.selectElementAttribute(ana.selects,"placeholder","选择阿姨角色").click();
        w.waitElementAttribute(10,this.selectElementAttribute(ana.selects,"placeholder","选择阿姨角色"),"tabindex","0");
        ana.reLoad();
        this.selectElement(ana.AllLi,"保洁阿姨").click();
    }
    /**
     * 基础信息4
     */
    @Test(priority = 5)
    public void BasicInformation4() {
        AddNewAunt ana = new AddNewAunt();
        /**
         * 选择阿姨居住地
         */
        ana.juzhudi_sheng.click();
        w.waitElementAttribute(10,ana.juzhudi_sheng,"aria-expanded","true");
        w.reFresh(10,selectElement(ana.AllLi,"北京"));
        ana.reLoad();
        this.selectElement(ana.AllLi,"北京").click();

        ana.juzhudi_shi.click();
        w.waitElementAttribute(10,ana.juzhudi_shi,"aria-expanded","true");
        w.reFresh(10,selectElement(ana.AllLi,"北京市"));
        ana.reLoad();
        this.selectElement(ana.AllLi,"北京市").click();

        ana.juzhudi_xian.click();
        w.waitElementAttribute(10,ana.juzhudi_xian,"aria-expanded","true");
        w.reFresh(10,selectElement(ana.AllLi,"朝阳区"));
        ana.reLoad();
        this.selectElement(ana.AllLi,"朝阳区").click();
        //详细地址
        this.selectElementAttribute(ana.inputs,"placeholder","输入阿姨居住详细地址...").sendKeys("光华路SOHO一期");
    }

    /**
     * 结算相关信息
     */
    @Test(priority = 6)
    public void bankInformation() {
        AddNewAunt ana = new AddNewAunt();
        //开户银行
        this.selectElementAttribute(ana.inputs,"placeholder","输入开户银行...").sendKeys("中国工商银行");
        //银行卡开户网点
        this.selectElementAttribute(ana.inputs,"placeholder","输入银行卡开户网点...").sendKeys("北京市朝阳区大悦城支行");
        //银行卡开户地
        this.selectElementAttribute(ana.inputs,"placeholder","输入银行卡开户地...").sendKeys("北京市朝阳区光华路");
        //银行卡号
        this.selectElementAttribute(ana.inputs,"placeholder","输入银行卡号...").sendKeys("4403071045716636");
        //点击创建按钮
        ana.createButton.click();
        /**
         * 等待页面刷新，然后设置排班表
         */
        w.waitElementAttribute(10,ana.body,"class","skin-blue fixed  pace-done");
        w.reFresh(10,ana.shijiankongjian);
        Assert.assertEquals(ana.pageText.getText(),AYXM);
        Reporter.log("阿姨创建成功");
    }
    /**
     * 排班表保存
     */
    @Test(priority = 7)
    public void paibanbiao() {
        int date1[] = getDate.getIntArrayDate();
        int day = date1[2];
        String dateStart = String.valueOf(date1[1]) + "/" + String.valueOf(day) + "/" + String.valueOf(date1[0]);
        int year = date1[0] + 5;
        String dateEnd = String.valueOf(date1[1]) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
        AddNewAunt ana = new AddNewAunt();
        ana.shijiankongjian.click();
        w.waitElementAttribute(10,ana.div,"class","drp-container input-group active");
        ana.reLoad();
        ana.paibanStartTime.clear();
        ana.paibanStartTime.sendKeys(dateStart);
        ana.paibanEndTime.clear();
        ana.paibanEndTime.sendKeys(dateEnd);
        ana.chooseButton.click();
        ana.savepaibanbiao.click();
        w.waitElementAttribute(10,ana.body,"class","skin-blue fixed  pace-done");
        try{
            ana.reLoad();
            ana.paibanbiaoSome.getText();
        } catch(NoSuchElementException e) {
            e.printStackTrace();
        }
        Reporter.log("阿姨排班表保存成功");
    }

    @Test(priority = 8)
    public void ayiguanli() {
        LookAllAunt lal = new LookAllAunt();
        this.underElementClick(this.selectElement(lal.links,"查看所有阿姨"));
        w.waitElementAttribute(10,lal.body,"class","skin-blue fixed  pace-done");
        lal.search_name.sendKeys(AYXM);
        lal.search_button.click();
        w.waitElementAttribute(10,lal.body,"class","skin-blue fixed  pace-done");
        Assert.assertEquals(this.selectElementAttribute(lal.ayinames,"title","查看").getText(),AYXM);
        Reporter.log("搜索完成");
        w.time(1);
        this.selectElementAttribute(lal.a_button,"title","管理").click();
        w.waitElementAttribute(10,lal.body,"class","skin-blue fixed  pace-done");
        lal.reLoad();
        this.selectElement(lal.lables,"通过").click();
        lal.button.click();
        w.waitElementAttribute(10,lal.body,"class","skin-blue fixed  pace-done");
        w.time(1);
        lal.reLoad();
        this.selectElement(lal.lables,"通过").click();
        lal.button.click();
        w.waitElementAttribute(10,lal.body,"class","skin-blue fixed  pace-done");
        w.time(1);
        lal.reLoad();
        this.selectElement(lal.lables,"通过").click();
        lal.button.click();
        w.waitElementAttribute(10,lal.body,"class","skin-blue fixed  pace-done");
        w.time(1);
        lal.reLoad();
        this.selectElement(lal.lables,"通过").click();
        lal.button.click();
        w.waitElementAttribute(10,lal.body,"class","skin-blue fixed  pace-done");
        w.time(1);
        lal.reLoad();
        lal.sue_but.click();
        w.waitElementAttribute(10,lal.body,"class","skin-blue fixed  pace-done");
        this.underElementClick(this.selectElement(lal.links,"查看所有阿姨"));
        w.waitElementAttribute(10,lal.body,"class","skin-blue fixed  pace-done");
        lal.search_name.sendKeys(AYXM);
        lal.search_button.click();
        w.waitElementAttribute(10,lal.body,"class","skin-blue fixed  pace-done");
        Assert.assertEquals(lal.order_status.getText(),"已上岗");
        Reporter.log("阿姨上岗管理完成");
    }
}
