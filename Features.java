package Selenium4;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Features {
	
	@Test
	public void screenshotTest() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rupal.garg\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		WebElement ele = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		File file = ele.getScreenshotAs(OutputType.FILE);
		
		File destfile = new File("ss.png");
		Files.copy(file, destfile);
		
		driver.quit();
	}
	
	@Test
	public void openNewTab() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rupal.garg\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.browserstack.com/");
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void openNewWindow() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rupal.garg\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("https://www.browserstack.com/");
		
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void Location() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rupal.garg\\Desktop\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		
		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		System.out.println("Height: "+logo.getRect().getDimension().getHeight());
		System.out.println("Width: "+logo.getRect().getDimension().getWidth());
		
		System.out.println("X Location: "+logo.getRect().getX());
		System.out.println("Y Location: "+logo.getRect().getY());
		
		Thread.sleep(5000);
		driver.quit();
	}

}
