package com.kent.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * @author Kent
 * @date 2018-02-26.
 */
@Controller
@RequestMapping("db")
@Slf4j
public class DbOpController {

    /**
     * 在使用ftl模板的时候，一定要引入freeMark的依赖
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }
}
