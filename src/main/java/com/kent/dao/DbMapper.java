package com.kent.dao;

import com.kent.controller.DbOpController;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

import com.kent.entity.SqlString;

/**
 * @author Kent
 * @date 2018-02-26.
 */
public interface DbMapper {
    @Select(value = "${sql}")
    List<HashMap<String, String>> queryDb(SqlString sql);

    @Select(value = "${sql}")
    List<Object> queryDb2(SqlString sql);

}
