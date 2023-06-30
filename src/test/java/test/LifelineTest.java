package test;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Lifeline;

public class LifelineTest {
	private static final WebDriver d = null;
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://lifelinehospitalkerala.com/");
		
	}
	@Test
	public void Test1() throws IOException
	{
		Lifeline l=new Lifeline(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		l.log();
		l.doctor();
		l.Searc("Dr.Jesna");
		l.appoinment();

		l.appoPage("Suresh S Surendran","Male","9878987656","suresh90@gmail.com"," India");
		
		String parentwindow=d.getWindowHandle();
		System.out.println("Parent Window Title"+d.getTitle());
		l.bookanappoin();
		Set<String> allwindowHandles = d.getWindowHandles();
		for(String handle:allwindowHandles)
		{
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				d.switchTo().window(handle);
				String s=d.findElement(By.xpath("/html/body/section[1]/div[1]/div[1]/h2")).getText();
				System.out.println(s);
				d.close();
			}
			d.switchTo().window(parentwindow);
		}
			
	}

}
