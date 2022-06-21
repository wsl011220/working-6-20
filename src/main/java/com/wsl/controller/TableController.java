package com.wsl.controller;

import com.wsl.Result.Result;
import com.wsl.entity.Table;
import com.wsl.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController

public class TableController {
    @Autowired
    TableService tableService;
    @RequestMapping("/find")
    public Result find() {


        return tableService.find();
    }
    @RequestMapping ("/delete")
    public Result delete(Table table) {


        return tableService.delete(table);
    }
    @RequestMapping ("/insert")
    public Result insert(Table table) {
        System.out.println("---------------------------------------------");
        System.out.println(table);
        System.out.println("---------------------------------------------");
        return tableService.insert(table);
    }
    @RequestMapping ("/update")
    public Result update(Table table) {


        return tableService.update(table);
    }
}
