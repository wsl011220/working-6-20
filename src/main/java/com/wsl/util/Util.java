package com.wsl.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.wsl.Result.Result;
import com.wsl.entity.Table;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public  class Util {
    public  Result daoru(){
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
//                System.out.println("解析数据为:" + table.toString());

            }
            // 全部解析完成被调用

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

                Integer totalCount = analysisContext.getCurrentRowNum();
                result.setTotal(totalCount);
                // 可以将解析的数据保存到数据库
            }
        }).sheet().doRead();

        result.setRows(list);
        return result;
    }
    public  List<Table> daoru2(){
        Result result = new Result();
        String filename = "D:\\user1.xlsx";
        File file = new File(filename);

        // 如果路径不存在
        if (!file.exists()) {
            // 创建多级路径
            file.mkdirs();
        }
        List<Table> list = new ArrayList<>();
        int total=0;
        // 读取excel
        EasyExcel.read(filename, Table.class, new AnalysisEventListener<Table>() {
            // 每解析一行数据,该方法会被调用一次
            @Override
            public void invoke(Table table, AnalysisContext analysisContext) {
                list.add(table);
//                System.out.println("解析数据为:" + table.toString());

            }
            // 全部解析完成被调用

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

                Integer totalCount = analysisContext.getCurrentRowNum();
                result.setTotal(totalCount);
                // 可以将解析的数据保存到数据库
            }
        }).sheet().doRead();

        result.setRows(list);
        return list;
    }
}
