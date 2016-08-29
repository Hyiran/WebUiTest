package webtest.core;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import webtest.core.TestCase.DriverManager;

public class Page {

	/**
	 * 构造方法，被所有Page的子类继承，所以每个页面都可以通过自动调用这个方法来初始化页面对象 
	 */
	public Page() {
		this.init();
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public void reLoad() {
		this.init();
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	/**
	 * 初始化页面的前置条件
	 */
	protected void init(){
		DriverManager.getDriver().switchTo().defaultContent();
	}

	/**
	 * id：标签的id
	 * yuansu:元素明
	 * className：class的名字
	 * 获取页面 某个标签（标签ID）下名字等于yuansu并且class名字等于className的所有元素
	 */
	public List<WebElement> getAllElement_ClassName(String id, String yuansu, String className) {

		@SuppressWarnings("unchecked")
		List<WebElement> inputs = (List<WebElement>) ((JavascriptExecutor)TestCase.DriverManager.getDriver()).executeScript(
				"var labels = document.getElementById('"+ id +"').getElementsByTagName('"+ yuansu +"');"+
						"var inputs = []; for (var i=0; i < labels.length; i++){" +
						"var radio = labels[i].getAttribute('class');"+
						"if(radio=='"+ className +"'){ inputs.push(labels[i]); }} return inputs;");
		return inputs;
	}

	/**
	 * id：标签的id
	 * yuansu:元素明
	 * 获取页面 某个标签（标签ID）下名字等于yuansu的所有元素
	 */
	public List<WebElement> getAllElement(String id,String yuansu) {

		@SuppressWarnings("unchecked")
		List<WebElement> inputs = (List<WebElement>) ((JavascriptExecutor)TestCase.DriverManager.getDriver()).executeScript(
				"var labels = document.getElementById('"+ id +"').getElementsByTagName('"+ yuansu +"'); return labels;");
		return inputs;
	}

}
