package com.kent.controller;

import com.kent.dao.DbMapper;
import com.kent.entity.SqlString;
import com.kent.service.DbOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * @author Kent
 * @date 2018-02-26.
 */
@RestController
@RequestMapping("db")
//@Slf4j
public class DbOpController {

    @Autowired
    private DbOpService dbOpService;

    /**
     * 在使用ftl模板的时候，一定要引入freeMark的依赖
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @PostMapping("execute")
    public String execute(@RequestParam("sql") String sql) {
        String dataJsonStr = dbOpService.execute2(sql);
        //JSONArray jsonObj = JSONArray.fromObject(dataJsonStr);
        System.out.println(dataJsonStr);
        return dataJsonStr;
    }
}
