package com.test.demo.common.utils;

import com.google.common.collect.Lists;
import com.test.demo.common.annotation.ExportAnnotation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * excel表格工具类
 *
 * @author Ben
 * @create 2018-10-24 16:34
 **/
public final class ExcelUtils {

    @Autowired
    private static JdbcTemplate jdbcTemplate;

    //最大导出行数
    private static final int MAX_ROW_COUNT = 10000;

    /**
     * 传入sql，直接转成excel
     *
     * @param sql      对应的sql 语句
     * @param clazz    导出对象的实体类
     * @param fileName 导出文件名
     * @param request
     * @param response
     */
    public static void sql2Excel(String sql, Class<?> clazz, String fileName, HttpServletRequest request, HttpServletResponse response) {
        List<?> list = Lists.newArrayList();
        try {
            list = jdbcTemplate.query("select * from(" + sql + ") where rownum<=" + MAX_ROW_COUNT, new BeanPropertyRowMapper<>(clazz));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("导出查询后台异常！");
        }
        try {
            //声明工作簿
            HSSFWorkbook wb = new HSSFWorkbook();
            //创建表格
            HSSFSheet sheet = wb.createSheet("Sheet1");
            if (!list.isEmpty()) {//结果集不为空
                //设置标题居中
                HSSFCellStyle titleCellStyle = wb.createCellStyle();
                titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
                //标题加粗
                HSSFFont font = wb.createFont();
                font.setBold(true);
                //生成标题行
                HSSFRow row = sheet.createRow(0);
                Field[] fields = clazz.getDeclaredFields();
                // 定义一个map用于存放列的序号和field.
                Map<Integer, Field> fieldsMap = new HashMap<>();
                for (Field field : fields) {
                    //判断字段上知否存在ExportAnnotation注解
                    if (field.isAnnotationPresent(ExportAnnotation.class)) {
                        //获取字段中包含ExportAnnotation的注解
                        ExportAnnotation exportAnnotation = field.getAnnotation(ExportAnnotation.class);
                        Integer excelCol = exportAnnotation.order();
                        field.setAccessible(true);
                        fieldsMap.put(excelCol, field);
                        HSSFCell cell = row.createCell(excelCol);

                    }


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建excel表格出错");
        }
    }


}
