package cases;

import org.testng.annotations.*;
import webtest.core.TestCase;
import webtest.core.util.Mysql;

/**
 * Created by han on 2016/1/20.
 */
public class Clean extends TestCase{
    Mysql jdbc = new Mysql();

    @Parameters({"target_sql_url", "target_sql_user", "target_sql_pwd"})
    @BeforeMethod
    public void init(String url, String user, String pass){
        jdbc.setUrl(url);
        jdbc.setUserName(user);
        jdbc.setPassWord(pass);
    }

    //重写方法-启动测试时不打开浏览器
    @Override
    protected void testMethodEnd() {}

    protected void testMethodStart(String driverName, String chromrPath, String iePath, String firefoxPath) {}

    @Test(dataProvider = "getData")
    public void clean(String jg, String sql){
        jdbc.connSQL();
        jdbc.updateSQL(sql);
        jdbc.deconnSQL();
        log.info(sql);
    }

}
