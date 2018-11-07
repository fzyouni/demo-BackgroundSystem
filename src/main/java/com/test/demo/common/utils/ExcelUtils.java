package com.test.demo.common.utils;

import com.google.common.collect.Lists;
import com.test.demo.common.annotation.ExportAnnotation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.*;

import static com.sun.xml.internal.xsom.impl.UName.comparator;

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
        list2Excel(list,clazz,fileName,request,response);
    }

    /**
     * 把list结果集导出到excel
     * @param list
     * @param clazz
     * @param fileName
     * @param request
     * @param response
     */
    public static void list2Excel(List<?> list, Class<?> clazz, String fileName, HttpServletRequest request, HttpServletResponse response){
        List<Field> fieldList = getOrderFiledList(clazz);
        HSSFWorkbook wb=null;
        try {
            //声明工作簿
            wb= new HSSFWorkbook();
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
                HSSFRow titleRow = sheet.createRow(0);
                for(int i=0;i<fieldList.size();i++){
                    titleRow.createCell(i).setCellValue(fieldList.get(i).getAnnotation(ExportAnnotation.class).fieldName());
                }
                //写入数据
                for(int i=0;i<list.size();i++){
                    HSSFRow DataRow = sheet.createRow(i+1);//创建行
                    for (int j=0;j<fieldList.size();j++){
                        DataRow.createCell(j).setCellValue(String.valueOf(fieldList.get(j).get(list.get(i))));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("创建excel表格出错");
        }
        try {
            response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
            fileName = java.net.URLEncoder.encode(fileName,"UTF-8");
            response.setHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes("UTF-8"),"GBK")+".xls");
            response.setContentType("application/msexcel");//定义输出类型
            ServletOutputStream outputStream =  response.getOutputStream();
            outputStream.flush();
            if(wb!=null){
                wb.write(outputStream);
            }
        }catch (Exception e){

        }
    }

    /**
     * 根据给的class 获取到bean上面的ExportAnnotation注解 并且根据order升序输出
     *
     * @param clazz
     * @return
     */
    private static List<Field> getOrderFiledList(Class<?> clazz) {
        if (clazz == null) {
            throw new RuntimeException("实体类不可为空！");
        }
        Field[] fields = clazz.getDeclaredFields();
        Map<Integer, Field> fieldsMap = new HashMap<>();
        for (Field field : fields) {
            //判断字段上知否存在ExportAnnotation注解
            if (field.isAnnotationPresent(ExportAnnotation.class)) {
                //获取字段中包含ExportAnnotation的注解
                ExportAnnotation exportAnnotation = field.getAnnotation(ExportAnnotation.class);
                Integer excelCol = exportAnnotation.order();
                field.setAccessible(true);
                if (fieldsMap.containsKey(excelCol)) {
                    throw new RuntimeException(clazz.getName() + "里面的" + field.getName() + "上面的ExportAnnotation注解order存在重复");
                }
                fieldsMap.put(excelCol, field);
            }
        }
        //根据order 排序之后的filed集合
        return sortMapByKey(fieldsMap);
    }

    /**
     * 根据map的key值排序
     *
     * @param map
     * @return
     */
    private static List<Field> sortMapByKey(Map<Integer, Field> map) {
        List<Field> result = new ArrayList<>();
        Set<Integer> keyInt = map.keySet();
        Set<Integer> set = new TreeSet<>(new MyComparator());
        set.addAll(keyInt);
        for (Integer key : set) {
            result.add(map.get(key));
        }
        return result;
    }

    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }


}
