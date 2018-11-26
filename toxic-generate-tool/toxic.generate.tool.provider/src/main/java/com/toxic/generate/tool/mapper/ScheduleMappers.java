/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.mapper;


import com.toxic.generate.tool.model.Schedule;
import com.toxic.generate.tool.model.query.ScheduleQuery;

import java.util.List;

public interface ScheduleMappers {

    List<Schedule> queryForList(ScheduleQuery scheduleQuery);

    Schedule selectById(Long id);

    Integer updateById(Schedule schedule);

    Boolean insert(Schedule refund);

    Integer deleteById(Long id);

}