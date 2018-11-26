/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 下午2:53.
 */
@Controller
public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    /** binder用于bean属性的设置 */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
    }
}
