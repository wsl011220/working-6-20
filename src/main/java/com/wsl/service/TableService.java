package com.wsl.service;


import com.wsl.Result.Result;
import com.wsl.entity.Table;


import java.util.List;

public interface TableService {
    Result find();
    Result delete(Integer id);

    Result insertorupdate(Table table);

    Result update(Table table);

    List<Table> daochu();
    Result finds(Integer pageNum,Integer pageSize);
}
