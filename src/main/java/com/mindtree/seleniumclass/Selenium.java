package com.mindtree.seleniumclass;



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		System.out.println(driver.getTitle());
		
		Actions action = new Actions(driver);
		
		//1
		driver.findElement(By.linkText("Hovers")).click();
		action.moveToElement(driver.findElement(By.className("figure"))).build().perform();
		WebElement web= driver.findElement(By.className("figcaption"));
		System.out.println(web.getText());
		driver.navigate().back();
		
		//2
		driver.findElement(By.linkText("Checkboxes")).click();
		WebElement checkbox =driver.findElement(By.xpath("//input[@type='checkbox']"));
		if(!checkbox.isSelected()) {
			checkbox.click();
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='checkbox']"));
		driver.navigate().back();
		
		//3
		driver.findElement(By.linkText("Inputs")).click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1234");
		driver.navigate().back();
		
		//4
		driver.findElement(By.linkText("Dropdown")).click();
		Select sel= new Select(driver.findElement(By.id("dropdown")));
		sel.selectByVisibleText("Option 2");
		driver.navigate().back();
		
		//5
		driver.findElement(By.linkText("File Upload")).click();
		WebElement upload= driver.findElement(By.id("file-upload"));
		
		upload.sendKeys("C:/text.txt");
		driver.findElement(By.id("file-submit")).click();
		driver.navigate().back();
		driver.navigate().back();
		
		//6
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		
		driver.navigate().back();
		
		//7
		driver.findElement(By.linkText("Key Presses")).click();
		WebElement input= driver.findElement(By.id("target"));
		input.sendKeys(Keys.BACK_SPACE);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.navigate().back();
		
		
		//8
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
		String tab = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for(String actual: handles) {
			if(!actual.equalsIgnoreCase(tab)) {
				driver.switchTo().window(actual);
				driver.get("http://the-internet.herokuapp.com/windows/new");
				
			}
		}
		WebElement multipalScreen = driver.findElement(By.className("example"));
		System.out.println(multipalScreen.getText());
		driver.get("http://the-internet.herokuapp.com/");
		 
		//9
		driver.findElement(By.linkText("Context Menu")).click();
		WebElement pop = driver.findElement(By.id("hot-spot"));
		action.contextClick(pop).perform();
		driver.switchTo().alert().accept();
	
	}

}
