package com.wsl.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.wsl.Vo.Result;
import com.wsl.entity.Table;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public  class Util {
    public  Result daoru(MultipartFile multipartFile){
        //文件上传前的名称
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(fileName);
        OutputStream out = null;
        try{
            //获取文件流，以文件流的方式输出到新文件
//    InputStream in = multipartFile.getInputStream();
            out = new FileOutputStream(file);
            byte[] ss = multipartFile.getBytes();
            for(int i = 0; i < ss.length; i++){
                out.write(ss[i]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Result result = new Result();



        System.out.println(file);
        List<Table> list = new ArrayList<>();

        // 读取excelf
        EasyExcel.read(file, Table.class, new AnalysisEventListener<Table>() {
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
        File f = new File(file.toURI());
        if (f.delete()){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        result.setRows(list);
        return result;
    }
    public  List<Table> daoru2(MultipartFile multipartFile){
        Result result = new Result();
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(fileName);
        OutputStream out = null;
        try{
            //获取文件流，以文件流的方式输出到新文件
//    InputStream in = multipartFile.getInputStream();
            out = new FileOutputStream(file);
            byte[] ss = multipartFile.getBytes();
            for(int i = 0; i < ss.length; i++){
                out.write(ss[i]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        List<Table> list = new ArrayList<>();
        int total=0;
        // 读取excel
        EasyExcel.read(file, Table.class, new AnalysisEventListener<Table>() {
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
        File f = new File(file.toURI());
        if (f.delete()){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        result.setRows(list);
        return list;
    }
}
