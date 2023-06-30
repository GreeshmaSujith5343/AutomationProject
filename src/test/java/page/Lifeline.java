package page;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Parameters;

public class Lifeline {
  WebDriver driver;
  By logo=By.xpath("/html/body/header/div[2]/div/div[1]/a/img") ;
  By Doc=By.xpath("//*[@id=\"wp_nav_menu-item-2519\"]/a/span");
  By searc=By.xpath("//*[@id=\"search\"]");
  By appoint=By.xpath("/html/body/header/div[2]/div/div[2]/div[1]/a[1]");
  By name=By.xpath("//*[@id=\"name\"]");
  By gender=By.xpath("//*[@id=\"select_gender\"]");
  By mobile=By.xpath("//*[@id=\"wpcf7-f1401-o1\"]/form/div[2]/div[1]/span[3]/input");
  By email=By.xpath("//*[@id=\"email\"]");
  By Nationality=By.xpath("//*[@id=\"wpcf7-f1401-o1\"]/form/div[2]/div[1]/span[5]/select");
  By booking=By.xpath("/html/body/header/div[2]/div/div[2]/div[1]/a[2]");

  
  
  public Lifeline(WebDriver driver) {
	// TODO Auto-generated constructor stub
	  this.driver=driver;
}
public void log()
  {
	  driver.findElement(logo).isDisplayed();
	  if(logo != null)
	  {
		  System.out.println("logo is present");  
	  }
	  else
	  {
		  System.out.println("logo is not present");
	  }
  }
  public void doctor() throws IOException
  {
	  driver.findElement(Doc).click();
	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileHandler.copy(src, new File("D://lifescreenshort.png"));
  }
  public void Searc(String Jesna)
  {
	  driver.findElement(searc).sendKeys(Jesna,Keys.ENTER);
  }
  public void appoinment()
  {
	  driver.findElement(appoint).click();
  }
  
  public void appoPage(String n,String g,String m,String e,String na)
  {
	  driver.findElement(name).sendKeys(n);
	  driver.findElement(gender).sendKeys(g);
	  driver.findElement(mobile).sendKeys(m);
	  driver.findElement(email).sendKeys(e);
	  driver.findElement(Nationality).sendKeys(na);
  }
  public void bookanappoin()
  {
	  
	  driver.findElement(booking).click();
  }
}

