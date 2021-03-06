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
        workBook.sheet("????????????").doWrite(tableService.daochu());
//        MultipartFile file = new MockMultipartFile("file", "xxx.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", byteArrayOutputStream.toByteArray());
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setCharacterEncoding("utf-8");
        // ????????????????????????????????????
        // ????????????????????????????????????????????????????????????????????????????????????
        // ??????????????????????????????
        ServletOutputStream outputStream = null;
        BufferedInputStream inputStream = null;
        try {
            outputStream = response.getOutputStream();
            inputStream = new BufferedInputStream(new FileInputStream( file));

            // ????????????????????????
            byte[] buffer = new byte[1024 * 8];

            // ?????????????????????????????????
            while (inputStream.read(buffer) != -1) {
                // ???
                outputStream.write(buffer);

                // ??????
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
            System.out.println("????????????");
        }else {
            System.out.println("????????????");
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

//        String path="??????";
//
//        File file= new File( path+".xlsx");
        OutputStream outputStream = new FileOutputStream(file);//D:/user1.xlsx
        // ???????????????
        List<Table> dataList = new ArrayList<>();
        // ?????????????????????
        List<Integer> columns = Arrays.asList();

        HashMap<Integer, String> annotationsMap = new HashMap<>();
        annotationsMap.put(6,"???????????????2000-01-01");

        HashMap<Integer, String[]> dropDownMap = new HashMap<>();
        // ???????????????
        String[] ags = {"???","???"};
        String[] school = {"???????????????","??????????????????"};
        dropDownMap.put(3,ags);
        dropDownMap.put(4,school);
        TitleHandler titleHandler = new TitleHandler(annotationsMap, dropDownMap);
//        TitleHandler titleHandler = new TitleHandler(columns, annotationsMap, dropDownMap);
        EasyExcelUtil.writeExcelWithModel(outputStream, dataList, Table.class, "sheetName", titleHandler);
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);

        // ????????????????????????????????????
        // ????????????????????????????????????????????????????????????????????????????????????
        // ??????????????????????????????
        ServletOutputStream outputStream1 = null;
        BufferedInputStream inputStream1 = null;
        try {
            outputStream1 = response.getOutputStream();
            inputStream1 = new BufferedInputStream(new FileInputStream( file));

            // ????????????????????????
            byte[] buffer = new byte[1024 * 8];

            // ?????????????????????????????????
            while (inputStream1.read(buffer) != -1) {
                // ???
                outputStream1.write(buffer);

                // ??????
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
            System.out.println("????????????");
        }else {
            System.out.println("????????????");
        }

        return "index.html";
    }

}
