package com.fankf.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author fankunfeng
 * @date 2022-05-25 17:41
 */
public class PoiExportExcelTest {
    /**
     * 2003版本（包含2003）以前的扩展名为.xls需要用HSSFWorkbook类操作
     * 和 07基本相似 就是把XSSFWorkbook换成HSSFWorkbook
     */

    public static String outputFile = "C:\\Users\\Administrator\\Desktop\\bingTuan企业名录.xlsx";

    public static void main(String argv[]) {

    }

    public void exportExcel2007() throws IOException {
        //创建工作簿 类似于创建Excel文件
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建 sheetname页名
        XSSFSheet sheet = workbook.createSheet("员工信息");
        sheet.setColumnWidth(3, 20 * 256);//给第3列设置为20个字的宽度
        sheet.setColumnWidth(4, 20 * 256);//给第4列设置为20个字的宽度
        //创建一行,下标从0开始
        XSSFRow row = sheet.createRow(0);
        //创建这行中的列,下标从0开始 （表头）
        XSSFCell cell = row.createCell(0);
        // 给cell 0下表赋值
        cell.setCellValue("姓名");
        //创建这行中的列,并给该列直接赋值
        row.createCell(1).setCellValue("年龄");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("生日");
        row.createCell(4).setCellValue("手机号");
        // 设置表里内容
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("T");
        row.createCell(1).setCellValue("保密");
        row.createCell(2).setCellValue("男");
        row.createCell(3).setCellValue("保密");
        row.createCell(4).setCellValue("12121212121");

        row = sheet.createRow(2);
        row.createCell(0).setCellValue("T");
        row.createCell(1).setCellValue("18");
        row.createCell(2).setCellValue("女");
        row.createCell(3).setCellValue("2000-01-01");
        row.createCell(4).setCellValue("12121212122");
        //设定 路径
        File file = new File("D:\\zph\\temp\\员工信息2007.xlsx");
        FileOutputStream stream = new FileOutputStream(file);
        // 需要抛异常
        workbook.write(stream);
        //关流
        stream.close();
    }

    public void exportExcel2003() throws IOException {
        //创建工作簿 类似于创建Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建 sheetname页名
        HSSFSheet sheet = workbook.createSheet("员工信息");
        //创建一行,下标从0开始
        HSSFRow row = sheet.createRow(0);
        //创建这行中的列,下标从0开始 （表头）
        HSSFCell cell = row.createCell(0);
        // 给cell 0下表赋值
        cell.setCellValue("姓名");
        //创建这行中的列,并给该列直接赋值
        row.createCell(1).setCellValue("年龄");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("生日");
        row.createCell(4).setCellValue("手机号");
        // 设置表里内容
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("T");
        row.createCell(1).setCellValue("保密");
        row.createCell(2).setCellValue("男");
        row.createCell(3).setCellValue("保密");
        row.createCell(4).setCellValue("12121212121");

        row = sheet.createRow(2);
        row.createCell(0).setCellValue("T");
        row.createCell(1).setCellValue("18");
        row.createCell(2).setCellValue("女");
        row.createCell(3).setCellValue("2000-01-01");
        row.createCell(4).setCellValue("12121212122");

        //第一种导出 给定路径
        //1设定 路径 创建文件读进来在写内容
        File file = new File("D:\\zph\\temp\\员工信息2003.xls");
        FileOutputStream stream = new FileOutputStream(file);
        // 需要抛异常
        workbook.write(stream);
        //关流
        stream.close();


    }

    public void exportExcel2003(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //第二种导出 从项目中获取模板
        //String realPath = request.getSession().getServletContext().getRealPath("/");
        Resource resource = new ClassPathResource("templates/员工信息2003Tem.xls");//jar包获取

        //创建工作簿 类似于创建Excel文件
        HSSFWorkbook workbookTem = new HSSFWorkbook(resource.getInputStream());
        //创建 sheetname页名
        HSSFSheet sheetTem = workbookTem.getSheet("员工信息");
        //HSSFSheet sheetTem = workbookTem.getSheetAt(0);
        HSSFRow rowTem = sheetTem.createRow(1);
        rowTem.createCell(0).setCellValue("xmtem");
        rowTem.createCell(1).setCellValue("nltem");
        rowTem.createCell(2).setCellValue("xbtem");
        rowTem.createCell(3).setCellValue("srtem");
        rowTem.createCell(4).setCellValue("sjhtem");
        ServletOutputStream outputStream = response.getOutputStream();
        response.reset();
        String fileName = URLEncoder.encode("员工信息TemOut.xls", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.setContentType("application/x-download;charset=UTF-8");
        // 对响应客户请求进行重新编码11
        //response.setCharacterEncoding("utf-8");

        workbookTem.write(outputStream);

        outputStream.close();
    }

    public String exportExcel2003(String s, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //第三种直接导出


        //创建工作簿 类似于创建Excel文件
        HSSFWorkbook workbookTem = new HSSFWorkbook();
        //创建 sheetname页名
        HSSFSheet sheet = workbookTem.createSheet("员工信息");
        //创建一行,下标从0开始
        HSSFRow row = sheet.createRow(0);
        //创建这行中的列,下标从0开始 （表头）
        HSSFCell cell = row.createCell(0);
        // 给cell 0下表赋值
        cell.setCellValue("姓名");
        //创建这行中的列,并给该列直接赋值
        row.createCell(1).setCellValue("年龄");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("生日");
        row.createCell(4).setCellValue("手机号");
        // 设置表里内容
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("T");
        row.createCell(1).setCellValue("保密");
        row.createCell(2).setCellValue("男");
        row.createCell(3).setCellValue("保密");
        row.createCell(4).setCellValue("12121212121");

        row = sheet.createRow(2);
        row.createCell(0).setCellValue("T");
        row.createCell(1).setCellValue("18");
        row.createCell(2).setCellValue("女");
        row.createCell(3).setCellValue("2000-01-01");
        row.createCell(4).setCellValue("12121212122");


        ServletOutputStream outputStream = response.getOutputStream();
        response.reset();

        String fileName = URLEncoder.encode("员工信息TemOut.xls", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        //response.setContentType("application/x-download;charset=UTF-8");
        response.setContentType("application/vnd.ms-excel");
        //response.setContentType("application/msexcel");
        // 对响应客户请求进行重新编码11
        //response.setCharacterEncoding("utf-8");

        workbookTem.write(outputStream);

        outputStream.close();
        return s;
    }

}
