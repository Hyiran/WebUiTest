package cases_ejj;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webtest.core.page_ejj.HomePage;
import webtest.core.page_ejj.ayiguanli.AddNewAunt;
import webtest.core.page_ejj.caiwuguanli.RefundAuditPage;
import webtest.core.page_ejj.dingdanguanli.CreateOrderPage;
import webtest.core.page_ejj.dingdanguanli.LookAllOrderPage;
import webtest.core.page_ejj.fuwugongyingshang.AddSupplierPage;
import webtest.core.page_ejj.fuwugongyingshang.LookAllSupplierPage;
import webtest.core.page_ejj.jiazhenggongshiguanli.AddNewHomemaking;
import webtest.core.page_ejj.jiazhenggongshiguanli.LookAllHomemaking;
import webtest.core.page_ejj.mendianduanli.AddShopPage;
import webtest.core.page_ejj.mendianduanli.LookAllShopPage;
import webtest.core.util.Wait;

/**
 * 测试首页所有链接有效性
 * @author Administrator
 * 封装成一个一个 的方法以供复用
 */
public class HomeLinkTest extends WebTest{
    //重写父类afterMethod方法，完成一个测试方法不关闭浏览器,当所有test都完成后再关闭浏览器
    @Override
    protected void testMethodEnd() {}

    @AfterClass
    public void after() {
        DriverManager.quitDriver();
    }

    Wait w = new Wait();

    @Parameters({"admin_user","admin_pass"})
    @Test(priority = 0)
    public void login(String user,String pass) {
        //调用已有测试方法进行测试
        LoginTest lt = new LoginTest();
        lt.login("登录成功", user, pass);
    }


    /**
     * 点击访问查看所有家政公司
     */
    @Test(priority = 1)
    public void click_LookAllHoemmaking() {
        HomePage hp = new HomePage();
        this.underElementClick(hp.lookAll_jiazhenggongshi);
        LookAllHomemaking ahp = new LookAllHomemaking();
        w.reFresh(10, ahp.pageText);
        Assert.assertEquals("所有家政公司", ahp.pageText.getText());
        Reporter.log("点击访问查看所有家政公司页面测试通过");
    }

    /**
     * 点击访问添加新家政
     */
    @Test(priority = 2)
    public void click_addNewHoemmaking() {
        HomePage hp = new HomePage();
        this.underElementClick(hp.addNew_jiazheng);
        AddNewHomemaking anhm = new AddNewHomemaking();
        w.reFresh(10, anhm.pageText);
        Assert.assertEquals("添加新家政", anhm.pageText.getText());
        Reporter.log("点击访问添加新家政页面测试通过");
    }

    /**
     * 点击访问查看所有门店
     */
    @Test(priority = 3)
    public void click_LookAllShop() {
        HomePage hp = new HomePage();
        this.underElementClick(hp.lookAll_mendian);
        LookAllShopPage lasp = new LookAllShopPage();
        w.reFresh(10, lasp.pageText);
        Assert.assertEquals("所有门店", lasp.pageText.getText());
        Reporter.log("点击访问查看所有门店页面测试通过");
    }

    /**
     * 点击访问添加新门店
     */
    @Test(priority = 4)
    public void click_AddNewShop() {
        HomePage hp = new HomePage();
        this.underElementClick(hp.add_mendian);
        AddShopPage asp = new AddShopPage();
        w.reFresh(10, asp.pageText);
        Assert.assertEquals("添加门店", asp.pageText.getText());
        Reporter.log("点击访问添加新门店页面测试通过");
    }

    /**
     * 点击访问查看所有供应商公司
     */
    @Test(priority = 5)
    public void click_LookAllSupplier() {
        HomePage hp = new HomePage();
        this.underElementClick(hp.lookAll_fuwugongyinghsang);
        LookAllSupplierPage lasup = new LookAllSupplierPage();
        w.reFresh(10, lasup.pageText);
        Assert.assertEquals("供应商管理", lasup.pageText.getText());
        Reporter.log("点击访问查看所有供应商公司页面测试通过");
    }

    /**
     * 点击访问添加供应商公司
     */
    @Test(priority = 6)
    public void click_AddSupplierPage() {
        HomePage hp = new HomePage();
        this.underElementClick(hp.add_gongyingshang);
        AddSupplierPage addslp = new AddSupplierPage();
        w.reFresh(10, addslp.pageText);
        Assert.assertEquals("添加供应商", addslp.pageText.getText());
        Reporter.log("点击访问添加供应商公司页面测试通过");
    }

    /**
     * 点击访问添加阿姨
     */
    @Test(priority = 6)
    public void click_AddNewAunt() {
        HomePage hp = new HomePage();
        this.underElementClick(hp.add_NewAunt);
        AddNewAunt addAunt = new AddNewAunt();
        w.reFresh(10, addAunt.pageText);
        Assert.assertEquals("录入新阿姨", addAunt.pageText.getText());
        Reporter.log("点击访问添加阿姨页面测试通过");
    }

    /**
     * 点击访问查看所有订单
     */
    @Test(priority = 7)
    public void click_lookAllOrder() {
        HomePage hp = new HomePage();
        this.underElementClick(hp.lookAllOrder);
        LookAllOrderPage laop = new LookAllOrderPage();
        w.reFresh(10, laop.orderList);
        Assert.assertEquals("订单管理", laop.pageText.getText());
        Reporter.log("点击访问查看所有订单页面测试通过");
    }

    /**
     * 点击访问人工下单
     */
    @Test(priority = 8)
    public void click_humanMakeOrder() {
        HomePage hp = new HomePage();
        this.underElementClick(hp.humenMakeOrder);
        CreateOrderPage ho = new CreateOrderPage();
        w.reFresh(10, ho.pageText);
        Assert.assertEquals("人工下单", ho.pageText.getText());
        Reporter.log("点击访问人工下单页面测试通过");
    }

    /**
     * 点击访问退款审核页面
     */
    @Test(priority = 9)
    public void click_tuikuanshenhe() {
        HomePage hp = new HomePage();
        this.underElementClick(hp.tuikuanshenhe);
        RefundAuditPage rap = new RefundAuditPage();
        w.reFresh(10, rap.pageText);
        Assert.assertEquals("退单审核", rap.pageText.getText());
        Reporter.log("点击访问退单审核页面测试通过");
    }

}
