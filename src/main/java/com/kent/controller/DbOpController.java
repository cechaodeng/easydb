package com.kent.controller;

import com.kent.dao.DbMapper;
import com.kent.dto.DataDTO;
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
    public DataDTO execute(@RequestParam("sql") String sql) {
        DataDTO dataDTO = dbOpService.execute(sql);
        //JSONArray jsonObj = JSONArray.fromObject(dataJsonStr);
        //System.out.println(dataDTO.getDataJsonStr());
        return dataDTO;
    }
}
