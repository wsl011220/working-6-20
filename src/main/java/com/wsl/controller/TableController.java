package com.wsl.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;

import com.wsl.Vo.Result;
import com.wsl.entity.Table;
import com.wsl.service.TableService;

import com.wsl.util.EasyExcelUtil;
import com.wsl.util.TitleHandler;
import com.wsl.util.Util;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
        Result result=new Result();
        if (table.getColumn1().equals("")&& table.getColumn1()==null&&
                table.getColumn2().equals("")&&table.getColumn2()==null&&
                table.getColumn3().equals("")&&table.getColumn3()==null&&
                table.getColumn4().equals("")&&table.getColumn4()==null&&
                table.getColumn5().equals("")&&table.getColumn5()==null&&
                table.getColumn6().equals("")&&table.getColumn6()==null&&
                table.getColumn7().equals("")&&table.getColumn7()==null&&
                table.getColumn8().equals("")&&table.getColumn8()==null&&
                table.getColumn9().equals("")&&table.getColumn9()==null  ){

        }else {
            result = tableService.insertorupdate(table);
        }
        return result;
    }
    @RequestMapping ("/daochu")
    public String daochu(HttpServletResponse response) {
        String filename="user1.xlsx";
        File file = new File(filename);
        ExcelWriterBuilder workBook=EasyExcel.write(file,Table.class);
        workBook.sheet("用户信息").doWrite(tableService.daochu());
//        MultipartFile file = new MockMultipartFile("file", "xxx.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", byteArrayOutputStream.toByteArray());
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setCharacterEncoding("utf-8");
        // 文件流分为字节流和字符流
        // 字节流可以读写任意类型的数据，因为字节是最基本的存储单元
        // 字符流只能读写纯文本
        ServletOutputStream outputStream = null;
        BufferedInputStream inputStream = null;
        try {
            outputStream = response.getOutputStream();
            inputStream = new BufferedInputStream(new FileInputStream( file));

            // 声明一个缓冲数组
            byte[] buffer = new byte[1024 * 8];

            // 只要没有读到文件的末尾
            while (inputStream.read(buffer) != -1) {
                // 写
                outputStream.write(buffer);

                // 刷新
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File f = new File(file.toURI());
        if (f.delete()){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        return "index.html";

    }
    @RequestMapping ("/daoru")
    public Result daoru(@RequestPart("ssssss") MultipartFile upload) {
        Util util = new Util();
        return util.daoru(upload);
    }
    @RequestMapping("/finds")
    public Result finds(Integer page,Integer rows) {
        page=page-1;
        return tableService.finds(page,rows);
    }
    @RequestMapping ("/inserts")
    public void inserts(@RequestPart("ssssss") MultipartFile upload) {
        Util util = new Util();
        List<Table> list = util.daoru2(upload);

        for (int i=0;i<list.size();i++){
            tableService.insertorupdate(list.get(i));
        }
    }
    @RequestMapping("/xiazaimuban")
    public String xiazaimuban(HttpServletResponse response)  throws IOException{
        String filename="user1.xlsx";
        File file = new File(filename);

//        String path="用户";
//
//        File file= new File( path+".xlsx");
        OutputStream outputStream = new FileOutputStream(file);//D:/user1.xlsx
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
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);

        // 文件流分为字节流和字符流
        // 字节流可以读写任意类型的数据，因为字节是最基本的存储单元
        // 字符流只能读写纯文本
        ServletOutputStream outputStream1 = null;
        BufferedInputStream inputStream1 = null;
        try {
            outputStream1 = response.getOutputStream();
            inputStream1 = new BufferedInputStream(new FileInputStream( file));

            // 声明一个缓冲数组
            byte[] buffer = new byte[1024 * 8];

            // 只要没有读到文件的末尾
            while (inputStream1.read(buffer) != -1) {
                // 写
                outputStream1.write(buffer);

                // 刷新
                outputStream1.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream1 != null) {
                    inputStream1.close();
                }
                if (outputStream1 != null) {
                    outputStream1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File f = new File(file.toURI());
        if (f.delete()){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        return "index.html";
    }

}
