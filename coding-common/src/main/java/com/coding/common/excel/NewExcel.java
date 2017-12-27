package com.coding.common.excel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/***************************************************************************************************
 * Copyright (c) 2017  Inc. All rights reserved.
 *  项目名称: coding
 *  模块名称: coding-common
 *  文件名称: NewExcel
 *  创建时间: 17-11-7 下午2:05
 *  最后更新时间： 17-11-1 下午1:05
 *   Author: mayuliang
 **************************************************************************************************/

public class NewExcel {
	private static final Logger logger = LoggerFactory.getLogger(NewExcel.class);

	public static void main(String[] args) throws Exception {

	}

	private static int createTitle(Sheet sheet, List<String[]> titleObject, int i, CellStyle style) {
		int rowIndex = i;
		for (String titles[] : titleObject) {
			Row row = sheet.createRow(rowIndex);
			// 列
			for (int t = 0; t < titles.length; t++) {
				Cell cell = row.createCell(t, Cell.CELL_TYPE_STRING);
				cell.setCellStyle(style);
				cell.setCellValue(titles[t]);
			}
			rowIndex++;
		}
		return rowIndex;
	}

	private static int fillData(Sheet sheet, List<String[]> dataList, int rowIndex, CellStyle style) {
		int rowIndexNew = rowIndex;
		for (String rowData[] : dataList) {
			Row row = sheet.createRow(rowIndexNew);
			// 列
			for (int i = 0; i < rowData.length; i++) {
				Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
				cell.setCellStyle(style);
				cell.setCellValue(rowData[i]);
			}
			rowIndexNew++;
		}
		return rowIndexNew;
	}

	@SuppressWarnings("unchecked")
	private static int createSheet(Map<String, Object> sheetMap, Workbook workbook) {
		Sheet sheet = workbook.createSheet(sheetMap.get("SHEET_NAME").toString());// SHEET名称
		sheet.setDefaultColumnWidth(12);
		List<String[]> dataList = (List<String[]>) sheetMap.get("SHEET_DATA");// SHEET数据
		List<String[]> titleObject = (List<String[]>) sheetMap.get("SHEET_TITLE");// SHEET标题数据

		// 创建sheet页面 头部
		int rowIndex = createTitle(sheet, titleObject, 0, getStyle(workbook, "title"));// 从第0行开始创建sheet页面表头
		// 填充数据
		int rowIndexNew = fillData(sheet, dataList, rowIndex, getStyle(workbook, "data")); // 从第rowIndex行开始创建sheet数据

		List<Map<String, Integer>> mergedRegion = getMergedList(titleObject.size(), titleObject.get(0).length, sheet);// SHEET合并单元格

		for (Map<String, Integer> merMap : mergedRegion) {
			// 数据定义 row_index 行索引从0开始 column_index 列索引 从0开始
			// span_row 跨行 span_column 跨列
			int row_index = merMap.get("row_index").intValue();
			int column_index = merMap.get("column_index").intValue();
			int span_row = merMap.get("span_row") != null ? merMap.get("span_row").intValue() + row_index
					: 0 + row_index;
			int span_column = merMap.get("span_column") != null ? merMap.get("span_column").intValue() + column_index
					: 0 + column_index;
			// 合并单元格
			sheet.addMergedRegion(new CellRangeAddress(row_index, span_row, column_index, span_column));
		}
		return rowIndexNew;
	}

	/**
	 * 根据标题生成 合并单元格 列表
	 * 
	 * @param titleObject
	 *            标题 如果单元格下一个行 and 一下列单元格 为空 则合并
	 * @return
	 */
	private static List<Map<String, Integer>> getMergedList(int titleRowLength, int titleColumnLength, Sheet sheet) {
		List<Map<String, Integer>> list = Lists.newArrayList();
		for (int r = 0; r <= titleRowLength - 1; r++) {
			for (int c = 0; c < titleColumnLength; c++) {
				Cell cell = sheet.getRow(r).getCell(c);
				if (StringUtils.isNotEmpty(cell.getStringCellValue())) {
					int columnIndex = c;
					int rowIndex = r;
					int span_column = 0;
					int span_row = 0;
					int nextR = r + 1;
					while (nextR < titleRowLength && sheet.getRow(nextR).getCell(c) != null
							&& StringUtils.isEmpty(sheet.getRow(nextR).getCell(c).getStringCellValue())) {
						nextR++;
						span_row = span_row + 1;
					}
					int nextC = c + 1;
					while (sheet.getRow(r).getCell(nextC) != null
							&& StringUtils.isEmpty(sheet.getRow(r).getCell(nextC).getStringCellValue())
							&& nextC < titleColumnLength && isNotMerged(r, nextC, list)) {
						nextC++;
						span_column = span_column + 1;
					}
					if (span_row > 0 || span_column > 0) {
						Map<String, Integer> map = Maps.newHashMap();
						map.put("row_index", rowIndex);
						map.put("column_index", columnIndex);
						map.put("span_row", span_row);
						map.put("span_column", span_column);
						list.add(map);
					}
				}
			}
		}
		return list;
	}

	/**
	 * 判断当前 单元格 合并单元格中
	 * 
	 * @param r
	 * @param c
	 * @param list
	 * @return
	 */
	private static boolean isNotMerged(int r, int c, List<Map<String, Integer>> list) {
		for (Map<String, Integer> mm : list) { // 3-9
			boolean _r = mm.get("row_index").intValue() <= r
					&& r <= mm.get("row_index").intValue() + mm.get("span_row").intValue();
			boolean _c = mm.get("column_index").intValue() <= c
					&& c <= mm.get("column_index").intValue() + mm.get("span_column").intValue();
			if (_r && _c) {
				//
				return false;
			}

		}
		return true;
	}

	/**
	 * @param filePath
	 *            文件全路径 支持xlsx
	 * @param dataList
	 *            每一个Map<String,Object>表示一个sheet页面数据描述
	 * 
	 *            Map<String,Object>：
	 * 
	 *            SHEET_NAME 名称sheet名称
	 * 
	 *            SHEET_DATA 数据字符串数据
	 * 
	 *            SHEET_TITLE 标题字符串数据 如果合并行列 标题名称空字符串表示
	 * 
	 * @throws Exception
	 */
	public static void createWorkbook(OutputStream os, List<Map<String, Object>> dataList) throws Exception {
		Workbook workbook = null;
		try {
			//
			workbook = new HSSFWorkbook();
			// 创建 sheet页面
			for (Map<String, Object> sheetMap : dataList) {
				createSheet(sheetMap, workbook);
				// logger.info("生成Excel-sheet<" + sheetMap.get("SHEET_NAME") +
				// ">行数：" + rowIndexNew);
			}
			workbook.write(os);
			os.flush();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception("创建Excel对象失败:" + e.getMessage(), e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.warn("关闭流异常!", e);
				}
			}
		}
	}

	/**
	 * @param filePath
	 *            文件全路径 支持xlsx
	 * @param dataList
	 *            每一个Map<String,Object>表示一个sheet页面数据描述
	 * 
	 *            Map<String,Object>：
	 * 
	 *            SHEET_NAME 名称sheet名称
	 * 
	 *            SHEET_DATA 数据字符串数据
	 * 
	 *            SHEET_TITLE 标题字符串数据 如果合并行列 标题名称空字符串表示
	 * 
	 * @throws Exception
	 */
	public static void createWorkbook(String filePath, List<Map<String, Object>> dataList) throws Exception {
		Workbook workbook = null;
		FileOutputStream os = null;
		try {
			//
			File f = new File(filePath);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			if (f.exists()) {
				f.delete();
			}
			f.createNewFile();
			os = new FileOutputStream(new File(filePath));
			if ("xlsx".equals(getFileSuffix(filePath))) {
				workbook = new XSSFWorkbook();
			} else {
				workbook = new HSSFWorkbook();
			}
			// 创建 sheet页面
			for (Map<String, Object> sheetMap : dataList) {
				createSheet(sheetMap, workbook);
				// logger.info("生成Excel-sheet<" + sheetMap.get("SHEET_NAME") +
				// ">行数：" + rowIndexNew);
			}
			workbook.write(os);
			os.flush();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception("创建Excel对象失败:" + e.getMessage(), e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.warn("关闭流异常!", e);
				}
			}
		}
	}

	private static CellStyle getStyle(Workbook workbook, String type) {
		// Excel头部样式
		CellStyle cellStyleHead = workbook.createCellStyle();
		if ("title".equals(type)) {
			cellStyleHead.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyleHead.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		}
		cellStyleHead.setBorderTop(CellStyle.SOLID_FOREGROUND);
		cellStyleHead.setBorderLeft(CellStyle.SOLID_FOREGROUND);
		cellStyleHead.setBorderRight(CellStyle.SOLID_FOREGROUND);
		cellStyleHead.setBorderBottom(CellStyle.SOLID_FOREGROUND);

		cellStyleHead.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyleHead.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		Font fontHead = workbook.createFont();
		if ("title".equals(type)) {
			fontHead.setBoldweight(Font.BOLDWEIGHT_BOLD);// 加粗
			fontHead.setFontHeightInPoints((short) 10);// 11号字体
			fontHead.setFontName("宋体");// 宋体
			cellStyleHead.setFont(fontHead);
		} else {
			fontHead.setFontHeightInPoints((short) 9);// 10号字体
			fontHead.setFontName("宋体");// 宋体
			cellStyleHead.setFont(fontHead);
		}
		return cellStyleHead;
	}

	private static String getFileSuffix(String filePath) {
		String suffix = "xls";
		if (filePath.endsWith("xlsx")) {
			suffix = "xlsx";
		}
		return suffix;
	}

	/**
	 * 导出EXCEL
	 * 
	 * @param dataList
	 * @param os
	 * @return
	 */
	public static boolean exportExcel(List<String[]> dataList, OutputStream os) {
		boolean b = true;
		try {
			// 创建Excel的工作书册 Workbook,对应到一个excel文档
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 声明一个Excel工作薄
			HSSFSheet sheet = workbook.createSheet("导出数据");
			HSSFRow row = null;
			int columnIndex = 0;
			int rowIndex = 0;
			row = sheet.createRow(rowIndex);
			// 设置表头
			CellStyle cellStyleHead = workbook.createCellStyle();
			// 数据单元格样式
			CellStyle bodyStyle = workbook.createCellStyle();
			cellStyleHead.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			cellStyleHead.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			cellStyleHead.setBorderTop(HSSFCellStyle.SOLID_FOREGROUND);
			cellStyleHead.setBorderLeft(HSSFCellStyle.SOLID_FOREGROUND);
			cellStyleHead.setBorderRight(HSSFCellStyle.SOLID_FOREGROUND);
			cellStyleHead.setBorderBottom(HSSFCellStyle.SOLID_FOREGROUND);

			HSSFFont fontHead = workbook.createFont();
			fontHead.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗
			fontHead.setFontHeightInPoints((short) 10);// 9号字体
			fontHead.setFontName("宋体");// 宋体
			cellStyleHead.setFont(fontHead);
			cellStyleHead.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
			cellStyleHead.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
			// 边框
			bodyStyle.setBorderTop(HSSFCellStyle.SOLID_FOREGROUND);
			bodyStyle.setBorderLeft(HSSFCellStyle.SOLID_FOREGROUND);
			bodyStyle.setBorderRight(HSSFCellStyle.SOLID_FOREGROUND);
			bodyStyle.setBorderBottom(HSSFCellStyle.SOLID_FOREGROUND);
			// 宋体9号
			HSSFFont font = workbook.createFont();
			font.setFontHeightInPoints((short) 9);
			font.setFontName("宋体");
			bodyStyle.setFont(font);
			bodyStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
			bodyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
			// 填充数据
			for (String[] arr : dataList) {
				columnIndex = 0;
				row = sheet.createRow(rowIndex);
				for (String cellText : arr) {
					HSSFCell cell = row.createCell(columnIndex);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					HSSFRichTextString richText = new HSSFRichTextString(cellText);
					cell.setCellValue(richText);
					if (rowIndex == 0) {
						cell.setCellStyle(cellStyleHead);
					} else {
						cell.setCellStyle(bodyStyle);
					}
					columnIndex++;
				}
				rowIndex++;
			}
			// 自适应
			for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
				sheet.autoSizeColumn(i, true);
			}
			// 导出excel
			workbook.write(os);
		} catch (Exception e) {
			b = false;
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.warn("关闭流异常!", e);
				}
			}
		}
		return b;
	}
}
