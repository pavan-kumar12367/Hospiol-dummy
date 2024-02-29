package hospiolpkg;

// TODO Auto-generated method stub

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class WriteToExcel {
		    WebDriver driver;

		    @BeforeMethod
		    public void setup() {
		      
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get("https://www.w3schools.com/html/html_tables.asp");
		    }

		    @Test
		    public void TableDataAndWriteToExcel() throws IOException {
			    WebElement table = driver.findElement(By.id("customers"));
			    List<WebElement> rows = table.findElements(By.tagName("tr"));
			    FileInputStream file = new FileInputStream("/newmavenproject/testdata//tutorial.xlsx");
			    XSSFWorkbook workbook = new XSSFWorkbook(file);
			    org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("TableData");

			    int rowCount = 0;
			    int rowsSize = rows.size();

			    for (int i = 0; i < rowsSize; i++) {
			        WebElement row = rows.get(i);
			        Row excelRow = sheet.createRow(rowCount++);

			        List<WebElement> cells = row.findElements(By.tagName("td"));
			        int cellCount = 0;
			        int cellsSize = cells.size();

			        for (int j = 0; j < cellsSize; j++) {
			            WebElement cell = cells.get(j);
			           // Cell excelCell = excelRow.createCell(cellCount++);
			            //excelCell.setCellValue(cell.getText());
			        }
			    }
		    }
		    @AfterMethod
		    public void close() {
		        driver.quit();
		    }
		}



