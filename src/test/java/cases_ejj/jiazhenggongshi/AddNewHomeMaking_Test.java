package cases_ejj.jiazhenggongshi;

import cases_ejj.HomeLinkTest;
import cases_ejj.LoginTest;
import cases_ejj.WebTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webtest.core.page_ejj.jiazhenggongshiguanli.AddNewHomemaking;
import webtest.core.util.Wait;
import webtest.core.util.getDate;
import webtest.core.page_ejj.jiazhenggongshiguanli.jiazhengxinxiPage;

/**
 * Created by Administrator on 2016-05-11.
 * 添加新家政公司
 */
public class AddNewHomeMaking_Test extends WebTest {

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
        hlt.click_addNewHoemmaking();
    }


    @Test(dataProvider = "getData")
    public void addJZ(String jg,String jiazhengName,String address,String bangongjiedao,String fuzeren,String phone,String zhizhaoName,String yingyedizhi,String farendaibiao,String zhucehao,String yingyezhizhaoURL) {
        int date[] = getDate.getIntArrayDate();
        /**
         * 设置家政公司名字后添加时间
         * 并输入家政公司名字
         */
        String dateSec = getDate.getDateSceond();
        AddNewHomemaking anhm = new AddNewHomemaking();
        String JZMZ = jiazhengName + "-时间:" +String.valueOf(date[1]) + "月" + String.valueOf(date[2] + "日" + dateSec);
        anhm.jiazhengName.sendKeys(JZMZ);
        /**
         * 选择地址
         */
        Select s1 = new Select(anhm.shengfen);
        Select s2 = new Select(anhm.chengshi);
        Select s3 = new Select(anhm.quxian);
        String add[] = address.split(" ");
        s1.selectByVisibleText(add[0]);
        s2.selectByVisibleText(add[1]);
        s3.selectByVisibleText(add[2]);
        /**
         * 输入办公街道、负责人、电话、其他联系方式
         */
        anhm.jiedao.sendKeys(bangongjiedao);
        anhm.fuzheren.sendKeys(fuzeren);
        anhm.dianhua.sendKeys(phone);
        anhm.qitalianxi.sendKeys("other");
        /**
         * 输入家政公司营业执信息
         * 营业执照名称、营业地址、注册类型、法人代表、注册号
         */
        anhm.yingyezhizhaoName.sendKeys(zhizhaoName);
        anhm.yingyeAddr.sendKeys(yingyedizhi);
        Select szclx = new Select(anhm.zhuceleixing);
        szclx.selectByVisibleText("商户");
        anhm.farendaibiao.sendKeys(farendaibiao);
        anhm.zhucehao.sendKeys(zhucehao);

        /**
         * 输入家政公司营业执信息
         * 注册时间、有效期起始时间、有效期结束时间、注册资本、营业执照URL、营业范围
         */

        date[2] = date[2] - 1;
        String date1 = String.valueOf(date[0]) + "-" + String.valueOf(date[1]) + "-" + String.valueOf(date[2]);
        date[0] = date[0] + 5;
        String date2 = String.valueOf(date[0]) + "-" + String.valueOf(date[1]) + "-" + String.valueOf(date[2]);
        anhm.zhuceTime.sendKeys(date1);
        anhm.youxiaokaishi.sendKeys(date1);
        anhm.youxiaojieshu.sendKeys(date2);
        anhm.zhuceziben.sendKeys("1000000");
        //附件上传
        anhm.yingyezhizhaoURL.sendKeys(yingyezhizhaoURL);
        anhm.yingyefanwei.sendKeys("家庭保洁、新居开荒");
        //点击创建按钮
        anhm.chaungjianButton.click();
        w.time(1);
        w.waitElementAttribute(10,anhm.body,"class","skin-blue fixed  pace-done");
        anhm.reLoad();
        w.reFresh(10,this.selectElement(anhm.managers,JZMZ));
        Assert.assertEquals(selectElement(anhm.managers,JZMZ).getText(),JZMZ);
        Assert.assertEquals(this.selectElement(anhm.managers,phone).getText(),phone);
        Reporter.log("创建家政公司成功");

    }
}
