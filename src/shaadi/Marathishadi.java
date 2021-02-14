package shaadi;

import java.io.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;



public class Marathishadi {

	
	public static void main(String[] args) throws InterruptedException, Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.marathishaadi.com/");
		Thread.sleep(3000);
			
		 driver.findElement(By.xpath("//button[contains(text(),\"Let's Begin\")]")).click();
		  
		
		//read data from csv file
		CSVReader reader = new CSVReader(new FileReader("E:\\csvfile\\notepad.csv"));
		String[] cell;
		
		
		  while((cell=reader.readNext())!= null) 
		  { 
			  for(int i=0;i<cell.length-1;i++) 
			  { 
				  String email= cell[i]; 
				  String pwd = cell[i+1];	  		  
				  driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
				  driver.findElement(By.xpath("//input[@name ='password1']")).sendKeys(pwd); 
			  }
		  
		
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
}
