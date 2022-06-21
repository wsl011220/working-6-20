package com.wsl.service.impl;

import com.wsl.Result.Result;
import com.wsl.dao.TableDao;
import com.wsl.entity.Table;
import com.wsl.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TableDao tableDao;
    @Override
    public Result find() {
        List <Table> list = tableDao.findAll();
        System.out.println(list);
        return new Result(list);
    }

    @Override
    public Result delete(Table table) {
        tableDao.delete(table);
        return new Result();
    }

    @Override
    public Result insert(Table table) {
       tableDao.save(table);
        return new Result();
    }

    @Override
    public Result update(Table table) {
        tableDao.save(table);
        return new Result();
    }
}
