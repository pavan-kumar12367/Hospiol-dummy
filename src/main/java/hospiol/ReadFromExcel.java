package hospiol;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ReadFromExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		        try {
		            // Specify the path of the Excel file
		            String filePath = "C:\\Users\\dell\\Desktop\\modules.xlsx";

		            // Create a FileInputStream object to read the Excel file
		            FileInputStream fis = new FileInputStream(filePath);

		            // Create a Workbook object
		            Workbook workbook = WorkbookFactory.create(fis);

		            // Get the first sheet from the workbook
		            Sheet sheet = workbook.getSheetAt(0);

		            // Iterate over all the rows in the sheet
		            for (Row row : sheet) {
		                // Iterate over all the cells in the row
		                for (Cell cell : row) {
		                    // Read the cell value and print it to the console
		                    System.out.print(cell.getStringCellValue()   + "\t\t");
		                }
		                // Move to the next line after printing all cell values in the row
		                System.out.println();
		            }

		            // Close the workbook and file input stream
		            workbook.close();
		            fis.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		

	}


