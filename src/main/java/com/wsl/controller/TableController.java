package com.wsl.controller;

import com.alibaba.excel.EasyExcel;
import com.wsl.Result.Result;
import com.wsl.entity.Table;
import com.wsl.service.TableService;
import com.wsl.util.EasyExcelUtil;
import com.wsl.util.TitleHandler;
import com.wsl.util.Util;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class TableController {
    @Autowired
    TableService tableService;
    @PostMapping  ("/delete")
    public Result delete(@RequestParam("ids[]") Integer[] ids) {
        for (int s:ids) {
            tableService.delete(s);
        }
        return new Result();
    }
    @RequestMapping ("/insert")
    public Result insertorupdate(Table table) {
        return tableService.insertorupdate(table);
    }
    @RequestMapping ("/daochu")
    public void daochu() {
        String filename = "D:\\user1.xlsx";
        File file = new File(filename);

        // 如果路径不存在
        if (!file.exists()) {
            // 创建多级路径
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(tableService.daochu());
        // 向Excel中写入数据 也可以通过 head(Class<?>) 指定数据模板
        EasyExcel.write(filename, Table.class)
                .sheet("用户信息")
                .doWrite(tableService.daochu());
    }
    @RequestMapping ("/daoru")
    public Result daoru() {
        Util util = new Util();
          return  util.daoru();
    }
    @RequestMapping("/finds")
    public Result finds(Integer page,Integer rows) {
        page=page-1;
        return tableService.finds(page,rows);
    }
    @RequestMapping ("/inserts")
    public void inserts() {
        Util util = new Util();
        List<Table> list = util.daoru2();

        for (int i=0;i<list.size();i++){
            tableService.insertorupdate(list.get(i));
        }
    }
    @RequestMapping("/xiazaimuban")
    public void xiazaimuban()  throws IOException{
        OutputStream outputStream = new FileOutputStream(new File("D:\\user1.xlsx"));
        // 导出的数据
        List<Table> dataList = new ArrayList<>();
        // 指定标红色的列
        List<Integer> columns = Arrays.asList();

        HashMap<Integer, String> annotationsMap = new HashMap<>();
        annotationsMap.put(6,"日期格式为2000-01-01");

        HashMap<Integer, String[]> dropDownMap = new HashMap<>();
        // 指定下拉框
        String[] ags = {"男","女"};
        String[] school = {"居民身份证","港澳台身份证"};
        dropDownMap.put(3,ags);
        dropDownMap.put(4,school);
        TitleHandler titleHandler = new TitleHandler(annotationsMap, dropDownMap);
//        TitleHandler titleHandler = new TitleHandler(columns, annotationsMap, dropDownMap);
        EasyExcelUtil.writeExcelWithModel(outputStream, dataList, Table.class, "sheetName", titleHandler);

    }
}
