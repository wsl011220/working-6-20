//package com.wsl.controller1;
//
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.write.builder.ExcelWriterBuilder;
//import com.wsl.Vo.Result;
//import com.wsl.entity.Table;
//import com.wsl.service.TableService;
//import com.wsl.util.EasyExcelUtil;
//import com.wsl.util.TitleHandler;
//import com.wsl.util.Util;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
//@RestController
//public class TableController1 {
//    @Autowired
//    TableService tableService;
//    @PostMapping  ("/delete")
//    public Result delete(@RequestParam("ids[]") Integer[] ids) {
//        for (int s:ids) {
//            tableService.delete(s);
//        }
//        return new Result();
//    }
//    @RequestMapping ("/insert")
//    public Result insertorupdate(Table table) {
//        Result result=new Result();
//        if (table.getColumn1().equals("")&& table.getColumn1()==null&&
//                table.getColumn2().equals("")&&table.getColumn2()==null&&
//                table.getColumn3().equals("")&&table.getColumn3()==null&&
//                table.getColumn4().equals("")&&table.getColumn4()==null&&
//                table.getColumn5().equals("")&&table.getColumn5()==null&&
//                table.getColumn6().equals("")&&table.getColumn6()==null&&
//                table.getColumn7().equals("")&&table.getColumn7()==null&&
//                table.getColumn8().equals("")&&table.getColumn8()==null&&
//                table.getColumn9().equals("")&&table.getColumn9()==null  ){
//
//        }else {
//           result = tableService.insertorupdate(table);
//        }
//        return result;
//    }
//    @RequestMapping ("/daochu")
//    public ModelAndView daochu(ModelAndView mv) {
//        String filename="user1.xlsx";
////        File file = new File(filename);
////        String path="??????";
////        // ?????????????????????
////        if (!file.exists()) {
////            // ??????????????????
////            file.mkdirs();
//////                file.createNewFile();
////        }
////        file= new File(filename +"/"+path+".xlsx");
////        mv.addObject("file",file);
//        // ???Excel??????????????? ??????????????? head(Class<?>) ??????????????????
//        ExcelWriterBuilder workBook=EasyExcel.write(filename,Table.class);
//        workBook.sheet("????????????").doWrite(tableService.daochu());
//
//        mv.addObject("file",workBook);
//        System.out.println(workBook);
//        return mv;
//    }
//    @RequestMapping ("/daoru")
//    public Result daoru(@RequestPart("ssssss") MultipartFile upload) {
//
//        System.out.println(upload);
//        System.out.println(upload.getOriginalFilename());
//        Util util = new Util();
//
//        return util.daoru(upload);
//    }
//    @RequestMapping("/finds")
//    public Result finds(Integer page,Integer rows) {
//        page=page-1;
//        return tableService.finds(page,rows);
//    }
//    @RequestMapping ("/inserts")
//    public void inserts(String filename) {
//        Util util = new Util();
//        List<Table> list = util.daoru2(filename);
//
//        for (int i=0;i<list.size();i++){
//            tableService.insertorupdate(list.get(i));
//        }
//    }
//    @RequestMapping("/xiazaimuban")
//    public void xiazaimuban()  throws IOException{
//        String filename="C:/Users/?????????/Downloads";
//        File file = new File(filename);
//                String path="??????";
//        // ?????????????????????
//        if (!file.exists()) {
//            // ??????????????????
//            file.mkdirs();
////                file.createNewFile();
//        }
//        file= new File(filename +"/"+path+".xlsx");
//        OutputStream outputStream = new FileOutputStream(file);//D:/user1.xlsx
//        // ???????????????
//        List<Table> dataList = new ArrayList<>();
//        // ?????????????????????
//        List<Integer> columns = Arrays.asList();
//
//        HashMap<Integer, String> annotationsMap = new HashMap<>();
//        annotationsMap.put(6,"???????????????2000-01-01");
//
//        HashMap<Integer, String[]> dropDownMap = new HashMap<>();
//        // ???????????????
//        String[] ags = {"???","???"};
//        String[] school = {"???????????????","??????????????????"};
//        dropDownMap.put(3,ags);
//        dropDownMap.put(4,school);
//        TitleHandler titleHandler = new TitleHandler(annotationsMap, dropDownMap);
////        TitleHandler titleHandler = new TitleHandler(columns, annotationsMap, dropDownMap);
//        EasyExcelUtil.writeExcelWithModel(outputStream, dataList, Table.class, "sheetName", titleHandler);
//
//    }
//}
