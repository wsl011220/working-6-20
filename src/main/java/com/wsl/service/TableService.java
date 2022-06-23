package com.wsl.service;

import com.wsl.Result.Result;
import com.wsl.entity.Table;
import com.wsl.entity.TableExcel;

import java.util.List;

public interface TableService {
    Result find(Integer page, Integer rows);
    Result delete(Integer id);

    Result insertorupdate(Table table);

    Result update(Table table);

    List<TableExcel> daochu();
}
