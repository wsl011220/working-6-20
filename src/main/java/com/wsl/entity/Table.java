package com.wsl.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@javax.persistence.Table(name = "table_1")
public class Table {
    @Id
    @Column(name = "Column_1")//绑定id列
    @ExcelProperty("uuid")
   private Integer column1;

    @Column(name = "Column_2")
    @ExcelProperty("姓名")
    private String  column2;

    @Column(name = "Column_3")
    @ExcelProperty("姓名全拼")
    private  String  column3;

    @Column(name = "Column_4")
    @ExcelProperty("性别")
    private  String  column4;


    @Column(name = "Column_5")
    @ExcelProperty("身份证证件")
    private  String  column5;

    @Column(name = "column_6")
    @ExcelProperty("身份证证件号")
    private String  column6;

    @ExcelProperty("出生日期")
    @Column(name = "Column_7")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date column7;

    @ExcelProperty("手机号码")
    @Column(name = "Column_8")
    private String  column8;

    @ExcelProperty("电子邮箱")
    @Column(name = "Column_9")
    private String  column9;

    @ExcelIgnore
    @Column(name = "createtime")
    @ExcelProperty("createtime")
    private Date    createtime;

    @ExcelIgnore
    @Column(name = "updatetime")
    @ExcelProperty("updatetime")
    private Date   updatetime;









}
