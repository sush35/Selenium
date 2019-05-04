package seleniumClassEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {
	static WebDriver driver;
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\spainaik\\Desktop\\Temp\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		List <WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int size = rows.size();
		String FP="//*[@id='customers']/tbody/tr[";
		String SP = "]/td[";
		String TP= "]";
		
		int colnum=2;
		ArrayList<String> ar=GetColumnDataList(FP, SP,TP,size,colnum);
		System.out.println(ar);
		
		HashMap<Integer,String> map = GetColumnDataMap(FP, SP,TP,size,colnum);
		System.out.println(map);
		
		driver.quit();
		
	}
	
	public static HashMap<Integer,String> GetColumnDataMap(String FP, String SP,String TP, int size, int colnum) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i =2; i<=size; i++){
			String XP = FP + i + SP + colnum + TP;

			map.put(i-1,driver.findElement(By.xpath(XP)).getText());
		}
		return map;
	}
	
	public static ArrayList<String> GetColumnDataList(String FP, String SP,String TP, int size, int colnum) {
		//*[@id="customers"]/tbody/tr[2]/td[1]
		ArrayList<String> ar= new ArrayList<String>();
		for(int i =2; i<=size; i++){
			String XP = FP + i + SP + colnum + TP;
			
			ar.add(driver.findElement(By.xpath(XP)).getText());
		}
		return ar;
	}

}
