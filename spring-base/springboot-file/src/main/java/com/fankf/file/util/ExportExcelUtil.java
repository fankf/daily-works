package com.fankf.file.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class ExportExcelUtil {


    // 导出数据
    public static HSSFWorkbook export(String title, String[] rowName, String[] rowType, List<Object> dataList) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        try {
            HSSFSheet sheet = workbook.createSheet(title);

            // 产生表格标题行
            HSSFRow rowm = sheet.createRow(0);
            HSSFCell cellTitle = rowm.createCell(0);


            //sheet样式定义【】
            HSSFCellStyle columnTopStyle = getColumnTopStyle(workbook);
            HSSFCellStyle style = getStyle(workbook);
            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, (rowName.length - 1)));
            cellTitle.setCellStyle(columnTopStyle);
            cellTitle.setCellValue(title);

            // 定义所需列数
            int columnNum = rowName.length;
            HSSFRow rowRowName = sheet.createRow(2);

            // 将列头设置到sheet的单元格中
            for (int n = 0; n < columnNum; n++) {
                HSSFCell cellRowName = rowRowName.createCell(n);
                cellRowName.setCellType(CellType.STRING);
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                cellRowName.setCellValue(text);
                cellRowName.setCellStyle(columnTopStyle);

            }
            // 将查询到的数据设置到sheet对应的单元格中
            for (int i = 0; i < dataList.size(); i++) {
                Object obj = dataList.get(i);// 遍历每个对象
                HSSFRow row = sheet.createRow(i + 3);// 创建所需的行数
                for (int j = 0; j < rowType.length; j++) {
                    String name = rowType[j];
                    name = name.substring(0,1).toUpperCase().concat(name.substring(1));
                    System.out.println(name);
                    Method methods = obj.getClass().getMethod("get"+name);
                    System.out.println( methods.invoke(obj));
                    HSSFCell cell = null;
                    if (j == 0) {
                        cell = row.createCell(j, CellType.NUMERIC);
                        cell.setCellValue(i + 1);
                    } else {
                        cell = row.createCell(j, CellType.STRING);
                        String v = methods.invoke(obj).toString();
                        if (!"".equals(v) && v != null) {
                            cell.setCellValue(v);
                        }
                    }
                    cell.setCellStyle(style);
                }

//                for (int j = 0; j < obj.length; j++) {
//                    HSSFCell cell = null;
//                    if (j == 0) {
//                        cell = row.createCell(j, CellType.NUMERIC);
//                        cell.setCellValue(i + 1);
//                    } else {
//                        cell = row.createCell(j, CellType.STRING);
//                        if (!"".equals(obj[j]) && obj[j] != null) {
//                            cell.setCellValue(obj[j].toString());
//                        }
//                    }
//                    cell.setCellStyle(style);
//
//                }

            }

            // 让列宽随着导出的列长自动适应
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell.getCellType() == CellType.STRING) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
                if (colNum == 0) {
                    sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
                } else {
                    sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
                }
            }
        } catch (Exception e) {

        }
        return workbook;
    }
    /*
     * 列头单元格样式
     */
    public static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();

        // 设置字体大小
        font.setFontHeightInPoints((short) 11);
        // 字体加粗
        font.setBold(true);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置低边框
        style.setBorderBottom(BorderStyle.DOUBLE);
        // 设置低边框颜色
        style.setBottomBorderColor(IndexedColors.BLUE.getIndex());
        // 设置右边框
        style.setBorderRight(BorderStyle.THICK);
        // 设置顶边框
        style.setTopBorderColor(IndexedColors.BLUE.getIndex());
        // 设置顶边框颜色
        style.setTopBorderColor(IndexedColors.BLUE.getIndex());
        // 在样式中应用设置的字体
        style.setFont(font);
        // 设置自动换行
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐；
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;

    }

    public static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short) 10);
        // 字体加粗
        font.setBold(true);
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置底边框;
        style.setBorderBottom(BorderStyle.THIN);
        // 设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        // 设置左边框;
        style.setBorderLeft(BorderStyle.THIN);
        // 设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        // 设置右边框;
        style.setBorderRight(BorderStyle.THIN);
        // 设置右边框颜色;
        style.setRightBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        // 设置顶边框;
        style.setBorderTop(BorderStyle.THIN);
        // 设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(false);
        // 设置水平对齐的样式为居中对齐;
        style.setAlignment(HorizontalAlignment.CENTER);
        // 设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        return style;
    }

    // 导出数据
    public static HSSFWorkbook exportToExcel(String path,String outFileName,String title, String[] rowName,String[] rowType, List list) throws Exception {
        File file=new File(path+outFileName);
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        HSSFWorkbook workbook =export(title,rowName,rowType,list);
        FileOutputStream output=new FileOutputStream(file);
        workbook.write(output);//写入磁盘
        output.close();
        return workbook;
    }


}


