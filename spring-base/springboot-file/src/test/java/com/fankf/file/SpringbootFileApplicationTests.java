package com.fankf.file;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.fankf.file.model.CompanyManagerPOI;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@SpringBootTest
class SpringbootFileApplicationTests {
    @Test
    void contextLoads2() {
        int i = DateUtil.parseLocalDateTime("2021-01-01 00:00:00").compareTo(LocalDateTime.now());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMM");
        YearMonth yearMonth = YearMonth.parse("202001", dateTimeFormatter);
        LocalDateTime localDateTime = yearMonth.atDay(1).atStartOfDay();
        System.out.println(i);
        System.out.println(localDateTime);

    }
    @Test
    void contextLoads() {

        File file = new File("C:\\Users\\wengegroup\\Desktop\\template.xlsx");
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(1);
        importParams.setTitleRows(0);

//        importParams.setSheetNum(1);
        List<CompanyManagerPOI> userObjects = ExcelImportUtil.importExcel(file, CompanyManagerPOI.class, importParams);

        for (CompanyManagerPOI userObject : userObjects) {
            System.out.println(JSON.toJSONString(userObject));
        }
    }

}
