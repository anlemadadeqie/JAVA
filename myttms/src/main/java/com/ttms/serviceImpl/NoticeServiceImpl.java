package com.ttms.serviceImpl;

import com.ttms.dao.NoticeDAO;
import com.ttms.entity.Notice;
import com.ttms.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by hjh on 16-12-10.
 */
@Service("NoticeServiceImpl")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeDAO noticeDAO;

    @Override
    public void insertNotice(Notice notice) {

        noticeDAO.insertNotice(notice);

    }

    @Override
    public void deleteNotice(int notice_id) {

        noticeDAO.deleteNotice(notice_id);

    }

    @Override
    public void updateNotice(Notice notice) {

        noticeDAO.updateNotice(notice);

    }

    @Override
    public Notice selectNoticeByNotice_id(int notice_id) {

        Notice notice = null;
        notice = noticeDAO.selectNoticeByNotice_id(notice_id);
        return notice;
    }

    @Override
    public List<Notice> selectNoticeByNotice_time(String notice_time) {

        List<Notice> list = null;
        list = noticeDAO.selectNoticeByNotice_time(notice_time);
        return list;
    }

    @Override
    public List<Notice> selectNoticeByNotice_title(String notice_title) {

        List<Notice> list = null;
        list = noticeDAO.selectNoticeByNotice_title(notice_title);
        return list;
    }

    @Override
    public List<Notice> selectNoticeByNotice_content(String notice_content) {

        List<Notice> list = null;
        list = noticeDAO.selectNoticeByNotice_content(notice_content);
        return list;
    }

    @Override
    public List<Notice> selectNotice() {

        List<Notice> list = null;
        list = noticeDAO.selectNotice();
        return list;
    }

    @Override
    public void addNotice(String notice_title, String notice_content) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String notice_time = formats.format(cal.getTime());
        Notice notice = new Notice();
        notice.setNotice_time(notice_time);
        notice.setNotice_title(notice_title);
        notice.setNotice_content(notice_content);
        noticeDAO.insertNotice(notice);

    }

    @Override
    public void changeNotice(String notice_id, String notice_title, String notice_content) {

        int id = Integer.parseInt(notice_id);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String notice_time = formats.format(cal.getTime());
        Notice notice = new Notice();
        notice.setNotice_id(id);
        notice.setNotice_time(notice_time);
        notice.setNotice_title(notice_title);
        notice.setNotice_content(notice_content);
        noticeDAO.updateNotice(notice);
    }
}
