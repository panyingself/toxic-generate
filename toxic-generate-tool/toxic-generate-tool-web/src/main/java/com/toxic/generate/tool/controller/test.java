/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.controller;

import com.toxic.generate.tool.model.Schedule;
import com.toxic.generate.tool.model.query.ScheduleQuery;
import com.toxic.generate.tool.service.ScheduleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/11/25 16:37.
 */
@Controller
@RequestMapping(value = "/test")
public class test {
    @Resource
    private ScheduleService scheduleService;
    @RequestMapping(value ="/test")
    @ResponseBody
    public String test(){
        List<Schedule> scheduleList = scheduleService.queryList(new ScheduleQuery());
        System.out.println(scheduleList.size());
        return "test";
    }

    @RequestMapping(value ="/testw")
    @ResponseBody
    public String test1(){
       scheduleService.insert(new Schedule());
        return "test";
    }
}
