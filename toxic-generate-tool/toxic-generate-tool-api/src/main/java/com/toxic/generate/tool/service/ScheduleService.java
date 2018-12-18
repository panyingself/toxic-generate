/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.service;


import com.toxic.generate.tool.model.Schedule;
import com.toxic.generate.tool.model.query.ScheduleQuery;

import java.util.List;

public interface ScheduleService {

    List<Schedule> queryList(ScheduleQuery scheduleQuery);

//    Page<Schedule> queryForList(Page<Schedule> page, ScheduleQuery refundQuery);

    Schedule selectById(Long id);

    Integer updateById(Schedule schedule);

    Boolean insert(Schedule refund);

    Integer deleteById(Long id);

}
