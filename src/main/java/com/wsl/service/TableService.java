package com.wsl.service;

import com.wsl.Result.Result;
import com.wsl.entity.Table;

public interface TableService {
    Result find();
    Result delete(Table table);

    Result insert(Table table);

    Result update(Table table);
}
