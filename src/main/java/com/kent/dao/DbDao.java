package com.kent.dao;

import com.kent.entity.SqlString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author Kent
 * @date 2018-02-27.
 */
@Component
public class DbDao {
    @Autowired
    private DbMapper dbMapper;


    List<HashMap<String, String>> queryDb(SqlString sqlString) {
        return dbMapper.queryDb(sqlString);
    }

    List<Object> queryDb2(SqlString sqlString) {
        return dbMapper.queryDb2(sqlString);
    }
}
