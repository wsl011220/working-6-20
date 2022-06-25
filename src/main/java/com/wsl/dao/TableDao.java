package com.wsl.dao;

import com.wsl.entity.Table;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;



@Repository(value = "TableDao")
public interface TableDao extends JpaRepository<Table,Integer> {
    @Query(value = "select * from table_1 " ,nativeQuery = true)
    Page<List<Table>> findS(Pageable pageable);
}
