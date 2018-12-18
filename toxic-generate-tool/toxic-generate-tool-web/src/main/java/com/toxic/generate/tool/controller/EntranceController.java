/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/6 上午11:32.
 */
@Controller
public class EntranceController {
    /**
     *主界面入口
     * @param
     * @return java.lang.String
     * @author py
     * @date  5:21 PM
     * @exception
     */
    @RequestMapping(value = "/index")
    public  String test1(){
        return "index";
    }
}
