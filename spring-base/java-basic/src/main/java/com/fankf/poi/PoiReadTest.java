package com.fankf.poi;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fankunfeng
 * @date 2022-05-25 21:42
 */
public class PoiReadTest {
    public static String outputFile = "C:\\Users\\Administrator\\Desktop\\bingTuan企业名录.xlsx";
    //    public static String outputFile3 = "C:\\Users\\Administrator\\Desktop\\湖南相关区域关键词(1).xlsx";
    public static String outputFile3 = "C:\\Users\\Administrator\\Desktop\\湖南相关媒体名单.xlsx";
    public static String keypoint = "C:\\Users\\Administrator\\Desktop\\keypoint.txt";
    public static String outputFile2 = "D:\\company.txt";

    public static void main(String[] args) throws Exception {
        File file = new File(outputFile3);
//        File file2 = new File("C:\\Users\\Administrator\\Desktop\\缺失企业.txt");
//        List<String> strings = FileUtils.readLines(file2, "UTF-8");
//        File file1 = new File("C:\\Users\\Administrator\\Desktop\\缺失企业tt.txt");
//        FileUtils.writeLines(file1,strings.stream().map(o->o.replace("　","")).collect(Collectors.toList()));
//        readExcel2(file);
//        File file1 = new File(outputFile2);
//        List<String> strings = FileUtils.readLines(file1, "UTF-8");
//        HashSet<String> strings1 = new HashSet<>(strings);
//        System.out.println(strings1.size());
//        System.out.println(LocalDate.now().minusDays(1).compareTo(LocalDate.now()));
        Set<String> keys = new HashSet<>();
        for (int z = 0; z < 5; z++) {
            ExcelReader reader = ExcelUtil.getReader(file, z);
            List<List<Object>> read = reader.read();

            for (int i = 1, readSize = read.size(); i < readSize; i++) {
                List<String> objectList = read.get(i).stream().map(String::valueOf).collect(Collectors.toList());
                String key = objectList.get(0).toString();
                keys.add(key);

//            List<String> collect = objectList.stream().map(String::valueOf)
//                    .filter(StringUtils::isNotBlank)
//                    .map(o->o.replace("（","(").replace("）","").replace(")",""))
//                    .collect(Collectors.toList());
//            for (String key : collect) {
//                String[] split = key.split("\\(");
//                for (String s : split) {
//                    String[] split1 = s.split(",");
//                    keys.addAll(Arrays.asList(split1));
//                }
//                break;
//            }

            }
        }
        File file1 = new File(keypoint);
        FileUtils.writeLines(file1, keys);
        System.out.println(String.join("\n", keys));
    }

    public static String readExcel2(File file) throws Exception {
        InputStream in = new FileInputStream(file);
        //D:\zph\temp
        // 多态  抛异常
        Workbook sheets = new XSSFWorkbook(in);
//        HSSFWorkbook sheets = new HSSFWorkbook(in);
        //获取一个工作表(sheet页)，下标从0开始
//        HSSFSheet sheet = sheets.getSheetAt(0);
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> companys = new ArrayList<>();
        for (int z = 0; z < 16; z++) {


            companys.add("标题");
            Sheet sheet = sheets.getSheetAt(z);
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 1; i <= lastRowNum; i++) {
                // 获取行数
                Row row = sheet.getRow(i);
                // 获取单元格 取值
//            String value1 = row.getCell(0).getStringCellValue();
//            String value2 = row.getCell(1).getStringCellValue();
                Cell cell = row.getCell(2);
                Cell cell6 = row.getCell(6);
                if (cell == null && cell6 == null) {
                    break;
                }
                String value3 = cell.getStringCellValue();
//            String value4 = row.getCell(3).getStringCellValue();
//            String value5 = row.getCell(4).getStringCellValue();

                if (StringUtils.isEmpty(value3)) {
                    break;
                }
                companys.add(value3.trim().replace(" ", "").replace("　", ""));

//            System.out.println(value1);
//            System.out.println(value2);
//            System.out.println(i+"==>"+value3);
//            System.out.println(value4);
//            System.out.println(value5);
            }
//            map.put(z, companys);

        }
        System.out.println("==> 开始导入");
        File file1 = new File("D:\\company.txt");
        FileUtils.writeLines(file1, new HashSet<>(companys));
        System.out.println("==> 导入完成");
//        for (Integer integer : map.keySet()) {
//            System.out.println(String.join(","));
//        }

        //关流
        sheets.close();
        in.close();

        return "hha";
    }

    @RequestMapping(value = "/upload")
    public String uploadExcel(@RequestParam("fileData") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream in = file.getInputStream();
        String s = readExcel(file, request, response);

        return s;
    }

    /**
     * spring mvc
     *
     * @param file
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String readExcel(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream in = file.getInputStream();
        //D:\zph\temp
        // 多态  抛异常
        //Workbook sheets = new XSSFWorkbook(stream);
        HSSFWorkbook sheets = new HSSFWorkbook(in);
        //获取一个工作表(sheet页)，下标从0开始
        HSSFSheet sheet = sheets.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            // 获取行数
            Row row = sheet.getRow(i);
            // 获取单元格 取值
            String value1 = row.getCell(0).getStringCellValue();
            String value2 = row.getCell(1).getStringCellValue();
            String value3 = row.getCell(2).getStringCellValue();
            String value4 = row.getCell(3).getStringCellValue();
            String value5 = row.getCell(4).getStringCellValue();

            System.out.println(value1);
            System.out.println(value2);
            System.out.println(value3);
            System.out.println(value4);
            System.out.println(value5);
        }


        //关流
        sheets.close();
        in.close();

        return "hha";
    }
}
