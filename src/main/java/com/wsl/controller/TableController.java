package com.wsl.controller;

import com.alibaba.excel.EasyExcel;
import com.wsl.Result.Result;
import com.wsl.entity.Table;
import com.wsl.service.TableService;
import com.wsl.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
}
