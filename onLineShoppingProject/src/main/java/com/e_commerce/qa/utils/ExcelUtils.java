package com.e_commerce.qa.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.e_commerce.qa.base.TestBase;

public class ExcelUtils extends TestBase {

	public static FileInputStream fi;
	public static FileOutputStream fo;

	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowCount(String xFile, String xSheet) throws Exception {

		int rowCount;

		fi = new FileInputStream(xFile);

		wb = new XSSFWorkbook(fi);

		ws = wb.getSheet(xSheet);

		rowCount = ws.getLastRowNum();

		wb.close();

		fi.close();

		System.out.println("The Row count is :" + rowCount);

		return rowCount;

	}

	public static int getCellCount(String xFile, String xSheet, int rowno) throws IOException {

		int colCount;

		fi = new FileInputStream(xFile);

		wb = new XSSFWorkbook(fi);

		ws = wb.getSheet(xSheet);

		row = ws.getRow(rowno);

		colCount = row.getLastCellNum();

		System.out.println("The cell count is :" + colCount);

		wb.close();

		fi.close();

		return colCount;

	}

	@SuppressWarnings("deprecation")
	public static String getCellData(String xFile, String xSheet, int rowno, int colno) throws IOException {

		String data;

		fi = new FileInputStream(xFile);

		wb = new XSSFWorkbook(fi);

		ws = wb.getSheet(xSheet);

		row = ws.getRow(rowno);
		cell = row.getCell(colno);

		/*
		 * DataFormatter df = new DataFormatter(); String value=
		 * df.formatCellValue(cell);
		 */

		cell.setCellType(cell.CELL_TYPE_STRING);

		data = cell.getStringCellValue();

		return data;

	}

	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws IOException {

		System.out.println("Inside Write Cell");

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);

		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		fi.close();
		fo.close();

	}

}
