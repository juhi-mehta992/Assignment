package shaadi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Marathishadi {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.marathishaadi.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(text(),\"Let's Begin\")]")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("juhi.1754@gmail.com");
		driver.findElement(By.xpath("//input[@name ='password1']")).sendKeys("test1234");
		
		WebElement profileFor = driver.findElement(By.xpath("//body/div[@id='___gatsby']/div[1]/div[7]/form[1]/div[2]/div[3]/div[1]/div[1]/div[1]"));
		profileFor.click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Self')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='gender_male']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		
		WebElement community = driver.findElement(By.xpath("//div[contains(text(),'Marathi')]"));
		String communityName=community.getText();
		System.out.println("getText is: "+communityName);
		if(communityName.equals("Marathi"))
		{
			System.out.println("Community name is correct");
		}
		else
		{
			System.out.println("Community name is not correct");
		}
		driver.close();
	}

}
