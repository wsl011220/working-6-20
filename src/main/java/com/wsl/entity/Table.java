package com.wsl.entity;

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

   private Integer Column1;
    @Column(name = "Column_2")
    private String  Column2;
    @Column(name = "Column_3")
    private  String  Column3;
    @Column(name = "Column_4")
    private  String  Column4;
    @Column(name = "Column_5")
    private  String  Column5;
    @Column(name = "Column_6")
    private String  Column6;

    @Column(name = "Column_7")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date Column7;

    @Column(name = "Column_8")
    private String  Column8;
    @Column(name = "Column_9")
    private String  Column9;
    @Column(name = "createtime")
    private Date    createtime;
    @Column(name = "updatetime")
    private Date   updatetime;








}
