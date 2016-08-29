package cases_ejj.dingdan.lookAllOrder;

import cases_ejj.HomeLinkTest;
import cases_ejj.LoginTest;
import cases_ejj.WebTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webtest.core.page_ejj.caiwuguanli.RefundAuditPage;
import webtest.core.page_ejj.dingdanguanli.LookAllOrderPage;
import webtest.core.util.Wait;

/**
 * Created by Administrator on 2016-04-14.
 */
public class CancelOrderTest extends WebTest{
    /**
     * orderCode:取消订单的订单号
     * orderMoney:订单金额
     * 退款审核需要用到，定义为常量
     */
    String orderCode;
    String orderMoney;
    Alert alert;

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
        hlt.click_lookAllOrder();
    }

    /**
     * 取消订单测试流程
     * 默认选择取消原因为“客户原因”，具体原因为“用户不需要”
     * 备注默认为“自动化测试取消订单”
     */
    @Parameters({"user_phone"})
    @Test(priority = 1)
    public void cancelOrderTest(String userPhone) {
        LookAllOrderPage laop = new LookAllOrderPage();
        laop.search_userPhoneNumber.sendKeys(userPhone);
        laop.searchButton.click();
        Assert.assertEquals(w.waitElementAttribute(10,laop.body,"class","skin-blue fixed  pace-done"),true);

        orderCode = laop.firstOrderCode;
        orderMoney = laop.orderMoney;
        w.reFresh(10,laop.searchButton);
        laop.cancelOrder.click();
        boolean b = true;
        while(b) {
            String s = laop.quxiaoform.getAttribute("style");
            if(s.equals("display: none;")) {

            } else {
                b = false;
                Reporter.log("取消订单form打开成功");
            }
        }
        /**
         * 选择取消原因为客户原因
         */
        laop.kehuyuanyin.click();
        Assert.assertEquals(true,laop.kehuyuanyin.isSelected());
        Reporter.log("选择取消原因为\"客户原因\"成功");
        /**
         * 选择具体原因为客户不需要
         */
        laop.kehubuxuyao.click();
        Assert.assertEquals(true,laop.kehubuxuyao.isSelected());
        Reporter.log("选择具体原因为\"客户不需要\"成功");
        /**
         * 输入备注信息
         * 点击提交按钮
         */
        laop.beizu.sendKeys("自动化测试取消订单");
        laop.querenanniu.click();

        /**
         * 等待alert出现 等待时间10秒
         * 获取取消订单成功alert ，并验证alert的提示信息是否为取消订单成功
         */
        w.waitAlert(10,alert);
        alert = DriverManager.getDriver().switchTo().alert();
        Assert.assertEquals("取消订单成功！",alert.getText());
        alert.accept();
        Reporter.log("取消订单操作成功");
        w.reFresh(10,laop.orderList);
        /**
         * 点击进入退款审核页面
         */
        HomeLinkTest hlt = new HomeLinkTest();
        hlt.click_tuikuanshenhe();
        /**
         * 搜索订单号
         */
        RefundAuditPage rap = new RefundAuditPage();
        rap.orderCodeInput_search.sendKeys(orderCode);
        rap.searchButton.click();
        w.reFresh(10,rap.shenhetongguoButton);
        /**
         * 检查搜索结果是否为刚刚取消订单的待审核退款信息
         * 检测等待时间10秒
         */
        for (int i = 0; i < 10 * 10; i++) {
            if(orderCode.equals(rap.firstOrderCode.getText())) {
                Reporter.log("搜索订单退款待审核信息成功");
                break;
            } else {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                    Reporter.log("没有搜索到订单：\" + orderCode + \"的退款待审核信息");
                }
            }
        }
        /**
         * 上面的判断已检测订单好是否一致
         * 检测订单退款金额与取消订单的金额是否一致
         * 如果一致点击审核通过按钮
         */
        if(orderMoney.equals(rap.orderMoney.getText().split("\\.")[0])) {
            rap.shenhetongguoButton.click();
        } else {Reporter.log("订单：\" + orderCode + \"的退款金额和取消订单的金额不一致");}
        /**
         * 等待alert出现等待时长为10秒
         * 对比alert内容是否为你确定退款?
         * 如果是点击alert的确定按钮
         */
        w.waitAlert(10,alert);
        Alert alert1 = DriverManager.getDriver().switchTo().alert();
        Assert.assertEquals("你确定退款?",alert1.getText());
        alert1.accept();
        /**
         * 等待alert出现等待时长为10秒
         * 对比alert内容是否为退款成功！
         * 如果是点击alert的确定按钮
         * 测试完成
         */
        w.waitAlert(10,alert);
        Alert alert2 = DriverManager.getDriver().switchTo().alert();
        Assert.assertEquals("退款成功！",alert1.getText());
        alert2.accept();
        w.reFresh(10,rap.searchButton);
        Reporter.log("用户退单财务审核通过 测试通过");

    }
}
