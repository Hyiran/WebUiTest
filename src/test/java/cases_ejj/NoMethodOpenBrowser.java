package cases_ejj;

import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import webtest.core.TestCase;

import java.util.List;

/**
 * Created by Administrator on 2016-05-25.
 * 重新TestCase的BeforeMethod和AfterMethod方法开始和结束不打开和关闭浏览器
 * 将这两个功能放在类开始和结束时
 */
public class NoMethodOpenBrowser extends TestCase {

    @AfterMethod
    @Override
    protected void testMethodEnd() {
    }

    @AfterClass
    protected void testClassEnd() {
        TestCase.DriverManager.quitDriver();
    }
/*
    @Parameters({"DriverName", "ChromeDriverPath", "IeDriverPath", "FirefoxDriverPath","index"})
    @BeforeClass
    protected void testClassStart(@Optional("firefox") String driverName,
                                  @Optional("classes/chromedriver.exe") String chromrPath,
                                  @Optional("classes/IEDriverServer.exe") String iePath,
                                  @Optional("moren") String firefoxPath,String url) {
        DriverManager.setupDriver(driverName, chromrPath, iePath, firefoxPath);
        TestCase.DriverManager.getDriver().manage().window().maximize();
        TestCase.DriverManager.getDriver().get(url);
    }
    */

    /**
     *
     * @param elements 元素List集合
     * @param text  检索内容
     * @return
     */
    public WebElement selectElement(List<WebElement> elements, String text) {
        for(WebElement element:elements) {
            if(element.getText().equals(text)) {
                return element;
            }
        }
        return null;
    }

    /**
     *
     * @param elements 元素List集合
     * @param attribute web标签名
     * @param text  检索内容
     * @return
     */
    public WebElement selectElementAttribute(List<WebElement> elements,String attribute,String text) {
        for(WebElement element:elements) {
            if(element.getAttribute(attribute).equals(text)) {
                return element;
            }
        }
        return null;
    }
}
