package com.wsl.service;


import com.wsl.Vo.Result;
import com.wsl.entity.Table;


import java.util.List;

public interface TableService {
    Result delete(Integer id);
    Result insertorupdate(Table table);
    List<Table> daochu();
    Result finds(Integer pageNum,Integer pageSize);
}
