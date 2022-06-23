package com.wsl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsl.Result.Result;
import com.wsl.dao.TableDao;
import com.wsl.entity.Table;
import com.wsl.entity.TableExcel;
import com.wsl.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TableDao tableDao;
    @Override
    public Result find(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List <Table>  list= tableDao.findAll();

        PageInfo<Table> tablePageInfo = new PageInfo<>(list);
        Result result = new Result();
        result.setRows(tablePageInfo.getList());
        result.setTotal((int) tablePageInfo.getTotal());

        return  result;
    }

    @Override
    public Result delete(Integer id) {
        tableDao.deleteById(id);
        return new Result();
    }

    @Override
    public Result insertorupdate(Table table) {

        Optional<Table> byId = tableDao.findById(table.getColumn1());

        if(byId==null&&byId.equals("")){
            Result result = new Result();
            table.setCreatetime(new Date());
            Table save = tableDao.save(table);
        }else {
           Result result = new Result();
            table.setUpdatetime(new Date());
            Table save = tableDao.save(table);
        }


        return new Result();
    }

    @Override
    public Result update(Table table) {
        tableDao.save(table);
        return new Result();
    }

    @Override
    public List<TableExcel> daochu() {
        List<TableExcel> tableExcels = new ArrayList<>();
//        tableExcels = tableDao.findAll();

            TableExcel tableExcel =new  TableExcel();
            tableExcel.setColumn1(111);
            tableExcel.setColumn2("admin");
            tableExcel.setColumn3("男");
            tableExcel.setColumn4("dsds");
            tableExcel.setColumn5("sdadadad");
            tableExcel.setColumn6("jn");
            tableExcel.setColumn7(new Date());
            tableExcel.setColumn8("sadd");
            tableExcel.setColumn9("sadd");
            tableExcel.setCreatetime(new Date());
            tableExcel.setUpdatetime(new Date());

            tableExcels.add(tableExcel);

        return tableExcels;

    }
}
