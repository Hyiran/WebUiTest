package cases_ejj.dingdan.lookAllOrder;

import cases_ejj.HomeLinkTest;
import cases_ejj.LoginTest;
import cases_ejj.WebTest;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webtest.core.page_ejj.dingdanguanli.LookAllOrderPage;
import webtest.core.page_ejj.dingdanguanli.RengongpaidanPage;
import webtest.core.util.Wait;

/**
 * Created by Administrator on 2016-04-25.
 */
public class ZhidingayiTest extends WebTest{


    Alert alert;
    Wait w = new Wait();
    //阿姨姓名
    String ayiName = "测试2";

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
        hlt.click_lookAllOrder();
    }

    /**
     * 为订单指派阿姨测试
     * 测试是否能成功指派阿姨
     */
    @Parameters({"user_phone"})
    @Test
    public void zhipaiayi(String userPhone) {
        /**
         * 搜索下单用户的手机号
         */
        String orderCoder;
        LookAllOrderPage laop = new LookAllOrderPage();
        laop.search_userPhoneNumber.sendKeys(userPhone);
        laop.searchButton.click();
        laop.reLoad();
        boolean boolea = w.waitElementAttribute(10,laop.body,"class","skin-blue fixed  pace-done");
        Assert.assertEquals(boolea,true);

        /**
         * 点击指派阿姨按钮
         * 等待进入人工派单页面
         * 检查进入页面是否为正确页面
         */
        orderCoder = laop.firstOrderCode;
        laop.assignedAunt.click();
        RengongpaidanPage rgpd = new RengongpaidanPage();
        w.reFresh(10,rgpd.pageText);
        if(orderCoder.equals(rgpd.orderCode.getText().split("：")[1]) == false) {
            System.err.println("进入人工派单页面失败");
            return;
        } else {
            Reporter.log("测试进入人工派单页面测试通过");
        }
        /**
         * 搜索阿姨等待阿姨出现
         */
        rgpd.searchInput.sendKeys(ayiName);
        rgpd.searchButton.click();
        boolean b = false;
        for(int i =0;i<100;i++) {
            try{
                Thread.sleep(100);
                if(!b) {
                    if(i == 99) {
                        System.err.println("没有搜索到阿姨信息");
                        return;
                    }
                    b = rgpd.ayiNameFirst.getText().equals(ayiName);
                } else {
                    Reporter.log("搜索阿姨信息成功");
                    break;
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        /**
         * 点击备注按钮
         * 等待备注信息弹出框弹出等待10秒
         * 备注阿姨信息并检查是否对比成功
         */
        rgpd.beizu.click();
        for(int i =0;i<100;i++) {
            try{
                Thread.sleep(100);
                if(i == 99) {
                    System.err.println("备注信息输入框没有弹出");
                    return;
                }else if(rgpd.tanchubeizhu.getAttribute("class").equals("modal fade in")) {
                    Reporter.log("备注信息弹出框弹出成功");
                    break;
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * 备注阿姨信息
         */
        rgpd.beizhuInput.clear();
        rgpd.beizhuInput.sendKeys("自动化测试备注");
        rgpd.beizhuButtonYes.click();

        /**
         * 等待弹出框关闭
         */
        for(int i =0;i<100;i++) {
            try{
                Thread.sleep(100);
                if(i == 99) {
                    System.err.println("备注信息输入框没有关闭");
                    return;
                }else if(rgpd.tanchubeizhu.getAttribute("style").equals("display: none;")) {
                    Reporter.log("备注信息弹出框关闭成功");
                    break;
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        /**
         * 检查备注信息是否正确
         */
        Assert.assertEquals(rgpd.ayibeizhu.getText().equals("自动化测试备注"),true);
        Reporter.log("备注阿姨信息成功");


        /**
         * 点击派单按钮，将该阿姨指派为这个订单
         * 等待alert出现并作出判断
         * 如果是正确的请款下点击确定按钮
         * 如果alert信息不正确的情况下打印alert信息
         * 并中断测试您确认此阿姨接单？
         */
        rgpd.paidanButton.click();
        w.waitAlert(10,alert);
        alert = DriverManager.getDriver().switchTo().alert();
        if(alert.getText().equals("您确认此阿姨接单？")) {
            alert.accept();
        } else {
            System.err.println(alert.getText());
            return;
        }
        w.time(1);
        /**
         * 等待自动跳转到查看所有订单页面
         * 并检查订单是否已经指派阿姨
         */
        w.reFresh(10,laop.pageText);
        Assert.assertEquals(w.waitElementAttribute(10,laop.body,"class","skin-blue fixed  pace-done"),true);
        Assert.assertEquals(laop.ayiName.getText().equals(ayiName),true);
        Reporter.log("指派阿姨测试通过");

    }

}
