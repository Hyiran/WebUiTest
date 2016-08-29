package webtest.core.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import webtest.core.TestCase.DriverManager;

public class PageTool {
	
	/**
	 * 重新载入页面同名元素集合
	 */
	public List<WebElement> reLoadByClass(List<WebElement> list, String className){
		list = null;
		list = DriverManager.getDriver().findElements(By.className(className));
		return list;
	}
	public List<WebElement> reLoadByTag(List<WebElement> list, String tagName){
		list = null;
		list = DriverManager.getDriver().findElements(By.tagName(tagName));
		return list;
	}
	public List<WebElement> reLoadByName(List<WebElement> list, String name){
		list = null;
		list = DriverManager.getDriver().findElements(By.name(name));
		return list;
	}

	/**
	 * 切换页签
	 * @return
	 */
	public String changeHandel() {
		String thisHandel = DriverManager.getDriver().getWindowHandle();
		Set<String> handels = DriverManager.getDriver().getWindowHandles();
		for (String s : handels) {
			if (!s.equals(thisHandel)) {
				DriverManager.getDriver().switchTo().window(s);
			}
		}
		return thisHandel;
	}

	public void changeHandel(String handel) {
		DriverManager.getDriver().switchTo().window(handel);
	}

	/**
	 *   自动截图功能
	 */

	public void snapshot(String fileName) {
		File screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("surefire-reports/image/" +fileName+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
