package com.ttms.dao;

import com.ttms.entity.ScheduleDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hjh on 16-12-10.
 */
@Repository("ScheduleDetailDAO")
public interface ScheduleDetailDAO {

    public List<ScheduleDetail> selectScheduleDetail();
    public ScheduleDetail selectOneScheduleDetail(int sched_id);
}
