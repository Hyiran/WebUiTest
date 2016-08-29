package cases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import webtest.core.TestCase;

/**
 * Created by han on 2016/1/22.
 */
public class WebTest extends TestCase{

    @Parameters({"index"})
    @BeforeMethod
    public void init(String url){
        TestCase.DriverManager.getDriver().get(url);
        TestCase.DriverManager.getDriver().manage().window().maximize();

        //针对首页新年欢迎页面
        try{
            DriverManager.getDriver().findElement(By.className("cbt_hsf_top_l")).click();
        }catch(Exception e){}
    }
}
