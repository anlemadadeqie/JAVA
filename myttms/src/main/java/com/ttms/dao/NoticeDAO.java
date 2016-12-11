package com.ttms.dao;

import com.ttms.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hjh on 16-12-10.
 */
@Repository("NoticeDAO")
public interface NoticeDAO {

    public void insertNotice(Notice notice);
    public void deleteNotice(int notice_id);
    public void updateNotice(Notice notice);

    public Notice selectNoticeByNotice_id(int notice_id);
    public List<Notice> selectNoticeByNotice_time(String notice_time);
    public List<Notice> selectNoticeByNotice_title(String notice_title);
    public List<Notice> selectNoticeByNotice_content(String notice_content);
    public List<Notice> selectNotice();
}
