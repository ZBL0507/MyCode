package com.zbl.util;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.StrUtil;
import com.zbl.dto.FieldDTO;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ddl文本操作工具类
 *
 * @author zbl
 * @version 1.0
 * @since 2022/12/22 21:04
 */
public class DDLUtils {

    //数据库的数据类型
    private final static List<String> dbDataTypeList = Arrays.asList(
            "tinyint", "smallint", "mediumint", "int", "bigint",
            "float", "double", "decimal",
            "year", "time", "date", "datetime", "timestamp",
            "char", "varchar", "blob", "text"
    );

    public static void main(String[] args) throws IOException {

        String fileName = "/Users/zhaobaoliang/Desktop/aaaa.txt";
        String outputFileName = "/Users/zhaobaoliang/Desktop/bbb.csv";

        List<FieldDTO> tableField = getTableField(fileName);
        writeCSV(tableField, outputFileName);
    }


    public static List<FieldDTO> getTableField(String ddlFilePath) {
        return getTableField(ddlFilePath, Charset.defaultCharset());
    }

    /**
     * 给定一个创建表的ddl文本文件的绝对路径地址，从而读取文件，解析出字段属性
     * 注意：必须要传入创建表的ddl文本文件绝对路径，否则将产生未定义的错误
     *
     * @param ddlFilePath 创建表的ddl文本文件的绝对路径地址
     * @param charset     字符编码集
     * @return 所有字段属性的集合
     */
    public static List<FieldDTO> getTableField(String ddlFilePath, Charset charset) {
        File ddlFile = new File(ddlFilePath);
        return getTableField(ddlFile, charset);
    }

    /**
     * 从一个创建表的ddl文本文件中解析出字段属性
     * 注意：必须要传入创建表的ddl文本文件，否则将产生未定义的错误
     *
     * @param ddlFile 创建表的ddl文本文件
     * @param charset 字符编码集
     * @return 所有字段属性的集合
     */
    public static List<FieldDTO> getTableField(File ddlFile, Charset charset) {
        FileReader fileReader = new FileReader(ddlFile, charset);
        List<String> lineList = fileReader.readLines();

        List<FieldDTO> fieldDTOList = new ArrayList<>();

        for (String line : lineList) {
            /*
             * 正常情况下，包含字段的行按照空格切割开，
             * 第一个字符串就是字段名
             * 第二个字符串就是数据类型
             * 最后一个字符串就是字段注释（当然也有可能没有没有注释）
             */
            String[] lineEles = line.trim().split("\\s+");
            if (lineEles.length < 2) {
                //含有字段的行至少两个元素
                continue;
            }
            if (!containsDBDataType(lineEles[1])) {
                //这一行不含有数据类型
                continue;
            }
            FieldDTO fieldDTO = new FieldDTO();
            fieldDTO.setFieldName(lineEles[0]);
            //判断是否包含注释
            String fieldComment = lineEles[0] + "(缺少注释)";
            for (int i = 2; i < lineEles.length; i++) {
                if ("comment".contains(lineEles[i].toLowerCase())) {
                    if (i + 1 == lineEles.length - 1) {
                        fieldComment = lineEles[i + 1];
                        break;
                    }
                }
            }

            //注释处理  注释, -> 注释
            if (fieldComment.endsWith(",")) {
                fieldComment = fieldComment.substring(0, fieldComment.length() - 1);
            }
            //注释处理  '注释' -> 注释
            if (fieldComment.startsWith("'")) {
                fieldComment = fieldComment.substring(1);
                if (fieldComment.endsWith("'")) {
                    fieldComment = fieldComment.substring(0, fieldComment.length() - 1);
                }
            }

            fieldDTO.setFieldComment(fieldComment);
            fieldDTOList.add(fieldDTO);
        }

        return fieldDTOList;
    }

    /**
     * 判断一个字符串是否包含数据库数据类型
     *
     * @param str 待判断的字符串
     * @return 如果包含返回true，反之false
     */
    public static boolean containsDBDataType(String str) {
        if (StrUtil.isEmpty(str))
            return false;

        for (String dbDataType : dbDataTypeList) {
            if (str.toLowerCase().contains(dbDataType))
                return true;
        }

        return false;
    }

    /**
     * 将一个java bean集合写入到CSV文件中
     *
     * @param beanList       java bean集合
     * @param outPutFilePath 输出文件路径
     * @param <T>            bean类型
     */
    public static <T> void writeCSV(List<T> beanList, String outPutFilePath) throws IOException {
        FileWriter fileWriter = new FileWriter(outPutFilePath);
        writeCSV(beanList, outPutFilePath, Charset.defaultCharset());
    }

    /**
     * 将一个java bean集合写入到CSV文件中
     *
     * @param beanList       java bean集合
     * @param outPutFilePath 输出文件路径
     * @param charset        字符编码集
     * @param <T>            bean类型
     */
    public static <T> void writeCSV(List<T> beanList, String outPutFilePath, Charset charset) throws IOException {
        java.io.FileWriter fileWriter = new java.io.FileWriter(outPutFilePath, charset);
        CsvWriter writer = CsvUtil.getWriter(fileWriter);
        writer.writeBeans(beanList);
    }
}
