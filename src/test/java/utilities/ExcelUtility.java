package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	
	public FileInputStream fileInput;
	public FileOutputStream fileOutput;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;

	
	
	public ExcelUtility(String path) {
		this.path=path;		
	}
	
	public int getRowCount(String sheetName) throws IOException {

	    fileInput = new FileInputStream(path);
	    workbook = new XSSFWorkbook(fileInput);
	    sheet = workbook.getSheet(sheetName);  
	    int rowcount = sheet.getLastRowNum();
	    workbook.close();
	    fileInput.close();

	    return rowcount;
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet=workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fileInput.close();
		return cellcount;
	}
	
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet= workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);			
		}
		catch(Exception e) {
			data="";
		}
		workbook.close();
		fileInput.close();
		return data;
	}
	
	public void setCellData(String sheetName, int rownum,int celnum,String data) throws IOException {
		File xlfile = new File(path);
		
		if(!xlfile.exists()) {
			workbook = new XSSFWorkbook();
			fileOutput = new FileOutputStream(path);
			workbook.write(fileOutput);
		 }
		
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		
		if(workbook.getSheetIndex(sheetName)==-1) 
			workbook.createSheet(sheetName);
			sheet=workbook.getSheet(sheetName);			
		 
		
		if(sheet.getRow(rownum)==null) 
			sheet.createRow(rownum);
			row=sheet.getRow(rownum);
		
		cell=row.createCell(celnum);
		cell.setCellValue(data);
		fileOutput = new FileOutputStream(path);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();	
	}
	
	public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet=workbook.getSheet(sheetName);	
		
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		style = workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();
	}
	public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet=workbook.getSheet(sheetName);	
		
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		style = workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();
	}
}
