package com.kevin.util;


import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright:WW
 * Author:kevin.ding
 * Date:2019/5/17
 * Description:
 */
public class ExcleUtil {
        /**
         * excel导 入
         */
	public static List<Map> readExcel(MultipartFile file) {
		List<Map> valueList = new ArrayList<Map>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());

			XSSFSheet sheet = workbook.getSheetAt(0); // 读取第一章表格内容
			// 定义 row、cell
			XSSFRow row;
			// 循环输出表格中的第一行内容 表头
			Map<Integer, String> keys = new HashMap<Integer, String>();
			// 得到Excel工作表的行
			row = sheet.getRow(0);
			if (row != null) {
				for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
					// 通过 row.getCell(j).toString() 获取单元格内容，
					if (row.getCell(j) != null) {
						if (!row.getCell(j).toString().isEmpty()) {
							keys.put(j, row.getCell(j).toString());
						}
					} else {
						keys.put(j, "K-R1C" + j + "E");
					}
				}
			}
			// 循环输出表格中的从第二行开始内容 row 行 cell 列
			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					boolean isValidRow = false;
					Map<String, Object> val = new HashMap<String, Object>();
//					System.out.println(row.getPhysicalNumberOfCells());
					for (int j = row.getFirstCellNum(); j <= row.getPhysicalNumberOfCells(); j++) {
						XSSFCell cell = row.getCell(j);
						if (cell != null) {
							String cellValue = null;
							cellValue = getXSSFCellCellValue(cell);
							val.put(keys.get(j), cellValue);
							if (!isValidRow && cellValue != null && cellValue.trim().length() > 0) {
								isValidRow = true;
							}
						}
					}
					// 第I行所有的列数据读取完毕，放入valuelist
					if (isValidRow) {
						valueList.add(val);
						System.out.println(val.toString());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {
//			try {
////				fis.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		return valueList;
	}
	
	private static String getXSSFCellCellValue(XSSFCell cell) {
		String cellValue = null;
		if (cell == null)
			return null;
		switch (cell.getCellType()) {
		case XSSFCell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				cellValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
				break;
			}
//			cellValue = df.format(cell.getNumericCellValue());
//			DecimalFormat df1 = new DecimalFormat("0.000000");
//			cellValue = df1.format(cell.getNumericCellValue());
			int value = (int)cell.getNumericCellValue();
			cellValue = value + "";

			break;
		case XSSFCell.CELL_TYPE_STRING:
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case XSSFCell.CELL_TYPE_FORMULA:
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case XSSFCell.CELL_TYPE_BLANK:
			cellValue = null;
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case XSSFCell.CELL_TYPE_ERROR:
			cellValue = String.valueOf(cell.getErrorCellValue());
			break;
		}
		if (cellValue != null && cellValue.trim().length() <= 0) {
			cellValue = null;
		}
		return cellValue;
	}
}
