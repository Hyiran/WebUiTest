package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import webtest.core.util.getDate;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class test {
	@Test
	public  void te() {

		List a = new ArrayList();
		a.add("soroke");
		a.add("song");
		a.add("ren");
		a.add("kun");
		System.out.println(a.get(0));
		for(int i=0; i<20;i++) {
			Random r = new Random();
			int n2 = r.nextInt(11);
			//n2 = Math.abs(r.nextInt() % 10);
			System.out.print(n2 + "\t");
		}



	}

	public List<WebElement> se(List<WebElement> ele) {
		List<WebElement> aaa = new ArrayList<>();
		String[] TwoHours = {"08:00-10:00","09:00-11:00","10:00-12:00","11:00-13:00","12:00-14:00","13:00-15:00","14:00-16:00","15:00-17:00","16:00-18:00","17:00-19:00","18:00-20:00"};

		for(int j=0;j<TwoHours.length;j++) {
			aaa.add(this.selectElementAttribute(ele,"value",TwoHours[j]));
		}
		return aaa;
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
