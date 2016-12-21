package com.ttms.dao;

import com.ttms.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hjh on 16-12-14.
 */
@Repository("PageDAO")
public interface PageDAO {

    public List<ScheduleDetail> selectScheduleByPage(@Param(value = "startPos") Integer startPos,
                                                     @Param(value = "pageSize") Integer pageSize);

    public long getScheduleCount();


    public List<Employee> selectEmployeeByPage(@Param(value = "startPos") Integer startPos,
                                             @Param(value = "pageSize") Integer pageSize);
    public long getEmployeeCount();

    public List<Employee> selectTopEmployeeByPage(@Param(value = "startPos") Integer startPos,
                                               @Param(value = "pageSize") Integer pageSize);
    public long getTopEmployeeCount();

    public List<Studio> selectStudioByPage(@Param(value = "startPos") Integer startPos,
                                           @Param(value = "pageSize") Integer pageSize);
    public long getStudioCount();

    public List<Play> selectPlayByPage(@Param(value = "startPos") Integer startPos,
                                       @Param(value = "pageSize") Integer pageSize);
    public long getPlayCount();

    public List<Notice> selectNoticeByPage(@Param(value = "startPos") Integer startPos,
                                       @Param(value = "pageSize") Integer pageSize);
    public long getNoticeCount();


}
