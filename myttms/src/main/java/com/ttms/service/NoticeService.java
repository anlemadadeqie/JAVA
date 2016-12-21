package com.ttms.service;

import com.ttms.entity.Notice;

import java.util.List;

/**
 * Created by hjh on 16-12-10.
 */
public interface NoticeService {

    public void insertNotice(Notice notice);
    public void deleteNotice(int notice_id);
    public void updateNotice(Notice notice);

    public Notice selectNoticeByNotice_id(int notice_id);
    public List<Notice> selectNoticeByNotice_time(String notice_time);
    public List<Notice> selectNoticeByNotice_title(String notice_title);
    public List<Notice> selectNoticeByNotice_content(String notice_content);
    public List<Notice> selectNotice();
    public void addNotice(String notice_title, String notice_content);
    public void changeNotice(String notice_id, String notice_title, String notice_content);


}
