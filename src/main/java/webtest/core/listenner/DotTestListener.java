package webtest.core.listenner;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import webtest.core.util.PageTool;

import java.util.Date;


/**
 * Created by han on 2016/3/28.
 */
public class DotTestListener extends TestListenerAdapter {
    /**
     * 当测试方法失败时，先截图
     * @param tr
     */
    @Override
    public void onTestFailure(ITestResult tr) {
        PageTool pt = new PageTool();
        pt.snapshot(new Date().getTime() + "Error");
        super.onTestFailure(tr);
    }

    /**
     * 测试方法成功时 也截图。。。
     * @param tr
     */
    @Override
    public void onTestSuccess(ITestResult tr) {
        PageTool pt = new PageTool();
        pt.snapshot(new Date().getTime() + "Success");
        super.onTestSuccess(tr);
    }
}