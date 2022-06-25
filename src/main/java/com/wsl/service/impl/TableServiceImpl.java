package com.wsl.service.impl;


import com.wsl.Result.Result;
import com.wsl.dao.TableDao;
import com.wsl.entity.Table;

import com.wsl.service.TableService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TableDao tableDao;

    @Override
    public Result find() {
        Result result = new Result();
        result.setRows(tableDao.findAll());

        return result ;
    }

    @Override
    public Result delete(Integer id) {
        tableDao.deleteById(id);
        return new Result();
    }

    @Override
    public Result insertorupdate(Table table) {
        Result result = new Result();
        Optional<Table> byId = tableDao.findById(table.getColumn1());


        if(byId.isPresent()){

            table.setUpdatetime(new Date());
            tableDao.save(table);
        }else {

            table.setCreatetime(new Date());
            tableDao.save(table);

        }


        return result;
    }

    @Override
    public Result update(Table table) {
        tableDao.save(table);
        return new Result();
    }

    @Override
    public List<Table> daochu() {
        List<Table> tableExcels = new ArrayList<>();
        tableExcels = tableDao.findAll();



        return tableExcels;

    }

    @Override
    public Result finds(Integer pageNum, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNum,pageSize);
        PageRequest pageReques = PageRequest.of(pageNum, pageSize);

        Page<List<Table>> s = tableDao.findS(pageReques);

        Result result = new Result();
          result.setRows(s.getContent());
            result.setTotal((int) s.getTotalElements());

        return result;


    }
}
