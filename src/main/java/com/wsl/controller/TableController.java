package com.wsl.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import com.wsl.Result.Result;
import com.wsl.entity.Table;

import com.wsl.service.TableService;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@RestController

public class TableController {
    @Autowired
    TableService tableService;
    @RequestMapping("/find")
    public Result find() {

        Result result = new Result();
         result = tableService.find();

        return result;
    }
    @PostMapping  ("/delete")
    public Result delete(@RequestParam("ids[]") Integer[] ids) {

        for (int s:ids) {
            tableService.delete(s);
        }
//        Result result = tableService.find();
        return new Result();
    }
    @RequestMapping ("/insert")
    public Result insertorupdate(Table table) {

        return tableService.insertorupdate(table);
    }
    @RequestMapping ("/daochu")
    public void daochu() {
        String filename = "D:\\user1.xlsx";
        System.out.println(tableService.daochu());
        // 向Excel中写入数据 也可以通过 head(Class<?>) 指定数据模板
        EasyExcel.write(filename, Table.class)
                .sheet("用户信息")
                .doWrite(tableService.daochu());


    }
    @RequestMapping ("/daoru")
    public Result daoru() {
        Result result = new Result();
        String filename = "D:\\user1.xlsx";
        File file = new File(filename);

        // 如果路径不存在
        if (!file.exists()) {
            // 创建多级路径
            file.mkdirs();
        }
       List<Table> list = new ArrayList<>();
        // 读取excel
        EasyExcel.read(filename, Table.class, new AnalysisEventListener<Table>() {
            // 每解析一行数据,该方法会被调用一次
            @Override
            public void invoke(Table table, AnalysisContext analysisContext) {
                list.add(table);
                System.out.println("解析数据为:" + table.toString());

            }
            // 全部解析完成被调用

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("解析完成...");

                // 可以将解析的数据保存到数据库
            }
        }).sheet().doRead();

//        System.out.println("-------------"+list);
        for (Table a:list
             ) {
            System.out.println(list);
        }
           result.setRows(list);
         return result;

    }






    @RequestMapping("/finds")
    public Result finds(Integer page,Integer rows) {
        page=page-1;
        return tableService.finds(page,rows);
    }







}
