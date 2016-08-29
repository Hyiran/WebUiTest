package cases_ejj.dingdan;

import cases.test;
import cases_ejj.HomeLinkTest;
import cases_ejj.LoginTest;
import cases_ejj.WebTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webtest.core.TestCase;
import webtest.core.page_ejj.dingdanguanli.CreateOrderPage;
import webtest.core.page_ejj.dingdanguanli.CreateOrderSuccessPage;
import webtest.core.util.Wait;
import webtest.core.util.getDate;

import java.util.List;
import java.util.Random;


/**
 * Created by Administrator on 2016-04-08.
 */
public class MakeOrder_Test extends WebTest {
    Wait w = new Wait();
    /**
     * 重写父类afterMethod方法，完成一个测试方法不关闭浏览器
     */
    @Override
    protected void testMethodEnd() {}

    /**
     * 执行完所有测试用例 关闭浏览器
     */
    @AfterClass
    public void after() {
        DriverManager.quitDriver();
    }

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
        hlt.click_humanMakeOrder();
    }

    /**
     * 添加下单地址
     * @param jg 预期结果
     * @param phoneNumber 用户手机号
     * @param addr 下单地址
     */
    @Test(dataProvider = "getData")
    public void addAddress(String jg,String phoneNumber,String addr,String fukuanfangshi,String xitongzhipai) {
        CreateOrderPage co = new CreateOrderPage();
        co.phoneNumber.sendKeys(phoneNumber);
        co.kehuxinxiDiV.click();
        Assert.assertEquals(w.waitElementAttribute(10,co.phoneDiv,"class","form-group field-order-order_customer_phone required has-success"),true);
        //w.reFresh(10,co.addressOne);
        int addrIndex = count_address();
        if(addrIndex == 0) {
            addAddress(addr);
        } else {
            String addressOne[] = co.addressOneInput.getText().split(" ");
            String userAddress = addressOne[0] + " " + addressOne[1] + " " +addressOne[2] + " " +addressOne[3];
            if(userAddress.equals(addr)) {
                co.addressOne.click();
            } else {
                co.addressOneButton.click();
                addAddress(addr);
            }
        }
        String addressOneText = co.addressOneInput.getText();
        String [] addressList = addressOneText.split(" ");
        String addressOne = addressList[0] + " " + addressList[1] + " " + addressList[2] + " " + addressList[3];
        Assert.assertEquals(addressOne,addr);
        Reporter.log("测试添加下单地址测试通过");
        /**
         * 点击选择保洁任务-家庭保洁
         */
        co.bjrw_click_xpath.click();
        Assert.assertEquals(co.bjrw_click_xpath.isSelected(),true);
        Reporter.log("选择保洁任务-家庭保洁测试通过");
        /**
         * 选择服务日期 服务时长 服务时间
         * 服务日期：获取系统当前日期并加一天 作为选择的服务日期
         * 服务时长：默认选择第一个2个小时
         * 服务时间：默认选择第一个8:00-10:00
         */
        this.setDate(getDate.getDate());
        co.serviceTimeTwo.click();
        co.serviceTimeOne.click();
        Assert.assertEquals(co.serviceTimeOne.isSelected(),true);
        Reporter.log("选择服务日期测试通过");
        Reporter.log("选择服务时长测试通过");
        Assert.assertEquals(w.waitElementAttribute(10,co.body,"class","skin-blue fixed  pace-done"),true);

        w.reFresh(10,co.fuwushijianduan);
        co.fuwushijianduan.click();
        if(co.fuwushijianduan.isSelected() == false) co.fuwushijianduan.click();
/*
//testst
        co.reLoad();
        test t = new test();
        List<WebElement> ttt = t.se(co.inputs);
        System.out.println("集合数量：" + ttt.size());
        Random r = new Random();

        for(int i=0;i<ttt.size();i++) {
            //int n2 = r.nextInt(11);
            System.out.println("第"+i+"个输出：" +ttt.get(i));
            //ttt.get(n2).click();
        }

        */

        Assert.assertEquals(co.fuwushijianduan.isSelected(),true);
        Reporter.log("选择服务时间段测试通过");
        /**
         * 选择支付方式 因现金支付取消所以不需要选择

        if(fukuanfangshi.equals("现金支付")) {
            co.xianjinzhifu.click();
            Assert.assertEquals(co.xianjinzhifu.isSelected(),true);
            Reporter.log("选择现金支付测试通过");
        } else {
            co.yuezhifu.click();
            Assert.assertEquals(co.yuezhifu.isSelected(),true);
            Reporter.log("选择余额支付测试通过");
        }*/
        /**
         * 选择是否系统指派     因系统指派选项去掉了所以注释代码

        if(xitongzhipai.equals("系统指派是")) {
            Assert.assertEquals(co.xitongzhipai_ture.isSelected(),true);
            Reporter.log("选择系统指派是测试通过");
        } else {
            co.xitongzhipai_false.click();
            Assert.assertEquals(co.xitongzhipai_false.isSelected(),true);
            Reporter.log("选择系统指派否测试通过");
        }*/
        /**
         * 点击创建待指派订单
         * 然后检查订单是否创建成功
         */
        co.chuangjiandaizhipaidingdan.click();
        CreateOrderSuccessPage cosp = new CreateOrderSuccessPage();
        w.waitElementAttribute(10,co.body,"class","skin-blue fixed  pace-done");
        w.reFresh(10,cosp.createOrder);
        String ad = cosp.orderAddress.getText();
        String add[] = ad.split(",");
        String addres = add[0] + " " + add[1] + " " + add[2] + " " + add[3];
        Assert.assertEquals(addres,addr);
        Reporter.log("订单创建成功！！！");
    }


    /**
     * 添加下单地址流程
     */
    public void addAddress(String address) {
        String addr[] = address.split(" ");
        CreateOrderPage co = new CreateOrderPage();
        Select s1 = new Select(co.sheng);
        Select s2 = new Select(co.shi);
        Select s3 = new Select(co.xian);
        s1.selectByVisibleText(addr[0]);
        s2.selectByVisibleText(addr[1]);
        s3.selectByVisibleText(addr[2]);
        co.xiangxi.clear();
        co.xiangxi.sendKeys(addr[3]);
        co.baocun.click();
        w.element(10,co.addressOneInput_xpath,"xpath");
        co.addressOneInput.click();
        //w.time(5);
    }

    /**
     * 查看当前手机号下有没有下单地址
     * @return 0代表没有 1代表有
     */
    public int count_address() {
            try{
                TestCase.DriverManager.getDriver().findElement(By.xpath("//*[@id='order-address_id']/div[1]/div[1]/select"));
                return 0;
            }catch(Exception e) {
                return 1;
            }
    }

    /**
     * 设置时间
     */
    public void setDate(String date) {
        CreateOrderPage co = new CreateOrderPage();
        JavascriptExecutor dates = (JavascriptExecutor) TestCase.DriverManager.getDriver();
        dates.executeScript("var setDate=document.getElementById(\"order-orderbookeddate\"); setDate.removeAttribute('readonly')");
        co.rili_input_id.clear();
        co.rili_input_id.sendKeys(date);
    }
}
