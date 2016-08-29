package cases_ejj.fuwugongyingshang;

import cases_ejj.HomeLinkTest;
import cases_ejj.LoginTest;
import cases_ejj.NoMethodOpenBrowser;
import org.testng.Reporter;
import org.testng.annotations.*;
import webtest.core.page_ejj.fuwugongyingshang.*;
import webtest.core.util.Wait;
import webtest.core.util.getDate;

/**
 * Created by Administrator on 2016-05-24.
 */
public class AddSuplierTest extends NoMethodOpenBrowser {
    Wait w = new Wait();
    /**
     * GYSMZ：服务供应商的名称
     * 名称格式例:05月26日15:33:50
     * phone:用户手机号后8位
     * 取的是日+时+分+秒 例：26150528
     * 就是26号15点05分28秒
     */
    String date[] = getDate.getStringArrayDate();
    String scen[] = getDate.getStringArrayDateSceond();
    String dateSec = getDate.getDateSceond();
    String GYSMZ = date[1] + "月" + date[2] + "日" + dateSec;
    String phone = date[2] + scen[0] + scen[1] + scen[2];

    /**
     * 获取时间
     * dateNow：当前日期
     * dateLast：当前时间减去五天
     * dateFuture：当前年份加上五年
     */
    int date1[] = getDate.getIntArrayDate();
    String dateNow = String.valueOf(date1[0]) + "-" + String.valueOf(date1[1]) + "-" + String.valueOf(date1[2]);
    int day = date1[2] - 5;
    String dateLast = String.valueOf(date1[1]) + "/" + String.valueOf(day) + "/" + String.valueOf(date1[0]);
    int year = date1[0] + 5;
    String dateFuture = String.valueOf(date1[1]) + "/" + String.valueOf(day) + "/" + String.valueOf(year);

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
        hlt.click_AddSupplierPage();
    }

    /**
     * 供应商基础信息
     */
    @Test(priority = 2)
    public void addSuplier() {
        /**
         * 输入服务供应商
         * 名称、电话、负责人、合同编号
         */
        AddSupplierPage asp = new AddSupplierPage();
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商名称...").sendKeys(GYSMZ);
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商电话...").sendKeys("147" + phone);
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商负责人...").sendKeys("Soroke");
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商合同编号...").sendKeys("2016052500001");
        Reporter.log("名称、电话、负责人、合同编号输入成功");
        /**
         * 选择省份、城市、区县、输入详细地址
         */
        asp.sheng.click();
        w.waitElementAttribute(10,asp.sheng,"aria-expanded","true");
        asp.reLoad();
        this.selectElement(asp.AllLi,"北京").click();
        w.time(1);
        asp.shi.click();
        w.waitElementAttribute(10,asp.shi,"aria-expanded","true");
        w.time(1);
        asp.reLoad();
        this.selectElement(asp.AllLi,"北京市").click();
        w.time(1);
        asp.xian.click();
        w.waitElementAttribute(10,asp.xian,"aria-expanded","true");
        w.time(1);
        asp.reLoad();
        this.selectElement(asp.AllLi,"朝阳区").click();
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商详细地址...").sendKeys("光华路22号光华路SOHO一期二单元719");
        Reporter.log("省份、城市、区县、详细地址输入成功");
    }

    /**
     * 营业执照信息
     */
    @Test(priority = 3)
    public void yingyezhizhao() {
        AddSupplierPage asp = new AddSupplierPage();
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商法人代表...").sendKeys("孙东明");
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商营业执照名称...").sendKeys("深圳市唐鼎实业有限公司");
        asp.upload.sendKeys("C:/Users/Public/Pictures/Sample Pictures/营业执照.jpg");
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商营业地址...").sendKeys("北京市朝阳区大悦城商圈");
        asp.zhuceleixing.click();
        w.waitElementAttribute(10,asp.zhuceleixing,"aria-expanded","true");
        w.reFresh(10,selectElement(asp.AllLi,"商户"));
        asp.reLoad();
        this.selectElement(asp.AllLi,"商户").click();
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商注册号...").sendKeys("2016010001");
        asp.gongyingshangzhuceshijian.sendKeys(dateNow);
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商注册资本...").sendKeys("10000000");
        asp.gongyingshangyouxiaoqi.click();
        w.waitElementAttribute(10,asp.gongyingshangyouxiaoqi,"class","drp-container input-group active");
        asp.reLoad();
        asp.time_start.clear();
        asp.time_start.sendKeys(dateLast);
        asp.time_end.clear();
        asp.time_end.sendKeys(dateFuture);
        asp.xuanzhe.click();
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商合同号...").sendKeys("家庭保洁、企业保洁");
        Reporter.log("营业执照信息输入成功");
    }

    /**
     * 银行信息
     */
    @Test(priority = 4)
    public void bankInfor() {
        AddSupplierPage asp = new AddSupplierPage();
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商银行名称...").sendKeys("中国工商银行");
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商银行开户地...").sendKeys("北京市朝阳区大悦城支行");
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商银行开户人...").sendKeys("孙东明");
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商银行卡号...").sendKeys("440307104571663");
        this.selectElementAttribute(asp.inputs,"placeholder","输入供应商银行支行名称...").sendKeys("朝阳大悦城支行");
        Reporter.log("银行信息输入成功");
        asp.createButton.click();
        w.waitElementAttribute(10,asp.body,"class","skin-blue fixed  pace-done");
        if(this.selectElement(asp.divs,GYSMZ) != null && this.selectElement(asp.divs,phone) != null) {
            Reporter.log("创建服务供应商成功");
        }
    }

}
