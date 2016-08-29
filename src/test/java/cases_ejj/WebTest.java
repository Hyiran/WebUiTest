package cases_ejj;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import webtest.core.TestCase;

import java.util.List;

/**
 * Created by Administrator on 2016-04-11.
 */
public class WebTest extends TestCase {
    @Parameters({"index"})
    @BeforeMethod
    public void init(String url){
        TestCase.DriverManager.getDriver().manage().window().maximize();
        TestCase.DriverManager.getDriver().get(url);
    }

    /**
     *
     * @param elements 元素List集合
     * @param text  检索内容
     * @return
     */
    public WebElement selectElement(List<WebElement> elements,String text) {
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
