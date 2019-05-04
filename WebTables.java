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

		ArrayList<ArrayList<String>> Table = new ArrayList<ArrayList<String>>();
		List <WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		List <WebElement> cols = driver.findElements(By.xpath("//table[@id='customers']//tr//th"));
		int row_size = rows.size();
		int col_size = cols.size();

		String XP_BeforeR_="//*[@id='customers']/tbody/tr[";
		String XP_Betwn = "]/td[";
		String XP_AfterC= "]";


		for (int i = 1; i<=col_size; i++){
			ArrayList<String> Col_data = new ArrayList<String>();
			Col_data = GetColumnDataList(XP_BeforeR_, XP_Betwn,XP_AfterC,row_size,i);
			Table.add(Col_data);
		}
		printColumnTable(Table);

		driver.quit();

	}

	public static HashMap<Integer,String> GetColumnDataMap(String FP, String SP,String TP, int size, int colnum) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i =1; i<=size; i++){
			String XP = FP + i + SP + colnum + TP;

			map.put(i-1,driver.findElement(By.xpath(XP)).getText());
		}
		return map;
	}

	public static ArrayList<String> GetColumnDataList(String FP, String SP,String TP, int size, int colnum) {
		ArrayList<String> ar= new ArrayList<String>();
		for(int i =2; i<=size; i++){
			String XP = FP + i + SP + colnum + TP;

			ar.add(driver.findElement(By.xpath(XP)).getText());
		}
		return ar;
	}
	
	public static void printColumnTable(ArrayList<ArrayList<String>> Table){
		int col_num = Table.size();
		int row_num = Table.get(1).size();

		for(int i=0; i<row_num; i++){
			for(int j=0; j<col_num; j++){
				System.out.format("%-32s",Table.get(j).get(i));
			}
			System.out.println();
		}
	}

}
