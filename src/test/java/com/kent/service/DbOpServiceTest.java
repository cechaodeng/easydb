package com.kent.service;

import com.kent.dao.DbMapper;
import com.kent.service.impl.DbOpServiceImpl;
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
public class DbOpServiceTest {
    @Autowired
    private DbOpServiceImpl dbOpService;

    @Test
    public void execute() throws Exception {
        //List<HashMap<String, String>> list = dbOpService.execute("select * from db");
        //System.out.println(list.size());
    }

}