/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.servic.impl;

import com.toxic.generate.tool.mapper.ScheduleMappers;
import com.toxic.generate.tool.model.Schedule;
import com.toxic.generate.tool.model.query.ScheduleQuery;
import com.toxic.generate.tool.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleMappers scheduleMappers;

    private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    public List<Schedule> queryList(ScheduleQuery scheduleQuery) {
        return scheduleMappers.queryForList(scheduleQuery);
    }

//    public Page<Schedule> queryForList(Page<Schedule> page, ScheduleQuery scheduleQuery) {
//        PageHelper.startPage(page.getCurrent(), page.getSize());
//        page.setRecords(scheduleMappers.queryForList(scheduleQuery));
//        return page;
//    }

    public Schedule selectById(Long id) {
        return scheduleMappers.selectById(id);
    }

    public Integer updateById(Schedule schedule) {
        return scheduleMappers.updateById(schedule);
    }

    public Boolean insert(Schedule schedule) {
        return scheduleMappers.insert(schedule);
    }

    public Integer deleteById(Long id) {
        return scheduleMappers.deleteById(id);
    }

}
