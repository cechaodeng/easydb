package com.kent.dao;

import com.kent.entity.SqlString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Kent
 * @date 2018-02-27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DbMapperTest {

    @Autowired
    private DbMapper mapper;

    @Test
    public void queryDb() throws Exception {
        List<HashMap<String, String>> list = mapper.queryDb(new SqlString("select * from db"));
        System.out.println(list.size());
    }

    @Test
    public void queryDb2() throws Exception {
        List<Object> list = mapper.queryDb2(new SqlString("select * from db"));
        System.out.println(list.size());
    }

}