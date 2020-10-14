package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel_Utility {


	
	public FileInputStream fis = null;
    public FileOutputStream fos = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
    String ExcelFilePath;
    
    public WriteExcel_Utility(String ExcelFilePath) throws Exception
    {
        this.ExcelFilePath = ExcelFilePath;
        fis = new FileInputStream(ExcelFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
     
    }
    
    public boolean setCellData(String sheetName, int colNumber, int rowNum, String value)
    {
        try
        {
        	sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            if(row==null)
                row = sheet.createRow(rowNum);
 
            cell = row.getCell(colNumber);
            if(cell == null)
                cell = row.createCell(colNumber);
 
            cell.setCellValue(value);
 
            fos = new FileOutputStream(ExcelFilePath);
            workbook.write(fos);
            fos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
        return true;
    }

}
