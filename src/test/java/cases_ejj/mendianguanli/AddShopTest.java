package cases_ejj.mendianguanli;

import cases_ejj.HomeLinkTest;
import cases_ejj.LoginTest;
import cases_ejj.WebTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webtest.core.page_ejj.mendianduanli.AddShopPage;
import webtest.core.page_ejj.mendianduanli.LookAllShopPage;
import webtest.core.util.Wait;
import webtest.core.util.getDate;

/**
 * Created by Administrator on 2016-05-17.
 * 添加新门店
 */
public class AddShopTest extends WebTest {

    Wait w = new Wait();

    /**
     * 前置条件，测试下单需要先登录 并进入下单页面
     * @param user 用户名
     * @param passwd 密码
     */
    @Parameters({"admin_user","admin_pass"})
    @BeforeMethod
    public void beforeMethod(String user,String passwd) {
        //调用已有测试方法进行测试
        LoginTest lt = new LoginTest();
        lt.login("登录成功", user, passwd);
        HomeLinkTest hlt = new HomeLinkTest();
        hlt.click_AddNewShop();
    }

    @Test(dataProvider = "getData")
    public void addMD(String jg,String mendianName,String address,String bangongjiedao,String fuzeren,String phone,String jiazhengName,String bankName,String zhihangName,String kaihuAddr,String kaihuren,String yinhangkahao) {
        int date[] = getDate.getIntArrayDate();
        /**
         * 设置门店名字后添加时间
         * 并输入门店名字
         */
        String dateSec = getDate.getDateSceond();
        AddShopPage asp = new AddShopPage();
        String MDMZ = mendianName + "-时间:" +String.valueOf(date[1]) + "月" + String.valueOf(date[2] + "日" + dateSec);
        asp.shopName.sendKeys(MDMZ);
        /**
         * 选择地址 和 办公街道
         */
        Select s1 = new Select(asp.shengfen);
        Select s2 = new Select(asp.chengshi);
        Select s3 = new Select(asp.quxian);
        String add[] = address.split(" ");
        s1.selectByVisibleText(add[0]);
        s2.selectByVisibleText(add[1]);
        s3.selectByVisibleText(add[2]);
        asp.jiedao.sendKeys(bangongjiedao);
        Reporter.log("选择地址和办公街道成功");
        /**
         * 选择归属家政公司
         * 点击下拉按钮，等待改span元素的aria-expanded选项变为true
         * 然后重新加载页面的所有元素
         * 选择家政公司并做点击
         */
        w.time(1);
        asp.guishujiazheng.click();
        w.waitElementAttribute(10,asp.guishujiazheng,"aria-expanded","true");
        w.time(1);
        asp.reLoad();
        this.selectElement(asp.AllLi,jiazhengName).click();
        //System.err.println(jiazhengName);process
        /**
         * 输入、负责人、电话、其他联系方式
         */
        asp.fuzheren.sendKeys(fuzeren);
        asp.dianhua.sendKeys(phone);
        asp.qitalianxi.sendKeys("other");
        Reporter.log("门店基础信息数据完成");

        /**
         * 设置银行信息
         * 选择开户行，具体操作与选择归属家政公司一致
         */
        asp.kaihuhang.click();
        w.waitElementAttribute(10,asp.kaihuhang,"aria-expanded","true");
        w.reFresh(10,selectElement(asp.AllLi,bankName));
        asp.reLoad();
        this.selectElement(asp.AllLi,bankName).click();

        /**
         * 输入支行名字、开户地址、开户人、银行卡号等信息
         */
        asp.zhihangName.sendKeys(zhihangName);
        asp.kaihuAddress.sendKeys(kaihuAddr);
        asp.kaihuren.sendKeys(kaihuren);
        asp.yinhangkahao.sendKeys(yinhangkahao);
        Reporter.log("银行信息输入成功");
        /**
         * 点击创建按钮
         */
        asp.createButton.click();

        /**
         * 等待页面跳转到查看所有门店页面，然后查询门店名字
         * 等待查询结果，并校验查询结果中的门店名字和手机和是否和创建的门店一直
         * 如果一直创建门店测试完成
         */
        LookAllShopPage lasp = new LookAllShopPage();
        w.reFresh(10,lasp.pageText);
        lasp.searchShopName.sendKeys(MDMZ);
        this.selectElement(lasp.buttons,"查询").click();
        w.waitElementAttribute(10,lasp.body,"class","skin-blue fixed  pace-done");

        Assert.assertEquals(lasp.firstShopName.getText(),MDMZ);
        Assert.assertEquals(lasp.firstShopPhone.getText(),phone);
        Reporter.log("门店添加成功");
    }
}
