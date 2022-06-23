package com.wsl.dao;

import com.wsl.entity.Table;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;


@Repository(value = "TableDao")
public interface TableDao extends JpaRepository<Table,Integer> {


}
