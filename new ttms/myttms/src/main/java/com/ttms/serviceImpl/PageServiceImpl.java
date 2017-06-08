package com.ttms.serviceImpl;

import com.ttms.dao.PageDAO;
import com.ttms.entity.*;
import com.ttms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjh on 16-12-14.
 */
@Service("PageServiceImpl")
public class PageServiceImpl implements PageService {


    @Autowired
    PageDAO pageDAO;

    @Override
    public void showScheduleByPage(HttpServletRequest request, String pageNow) {


        Page pages = null;
        List<ScheduleDetail> list = new ArrayList<ScheduleDetail>();
        int totalCount = (int)pageDAO.getScheduleCount();

        if(pageNow != null){
            pages = new Page(totalCount, Integer.parseInt(pageNow));
            list = pageDAO.selectScheduleByPage(pages.getStartPos(), pages.getPageSize());
        }else{
            pages = new Page(totalCount, 1);
            list = pageDAO.selectScheduleByPage(pages.getStartPos(), pages.getPageSize());

        }

        request.setAttribute("list", list);
        request.setAttribute("pages", pages);

    }

    @Override
    public void showEmployeeByPage(HttpServletRequest request, String pageNow) {


        Page pages = null;
        List<Employee> list = new ArrayList<Employee>();
        int totalCount = (int)pageDAO.getEmployeeCount();

        if(pageNow != null){
            pages = new Page(totalCount, Integer.parseInt(pageNow));
            list = pageDAO.selectEmployeeByPage(pages.getStartPos(), pages.getPageSize());
        }else{
            pages = new Page(totalCount, 1);
            list = pageDAO.selectEmployeeByPage(pages.getStartPos(), pages.getPageSize());

        }

        request.setAttribute("list", list);
        request.setAttribute("pages", pages);




    }

    @Override
    public void showTopEmployeeByPage(HttpServletRequest request, String pageNow) {

        Page pages = null;
        List<Employee> list = new ArrayList<Employee>();
        int totalCount = (int)pageDAO.getTopEmployeeCount();

        if(pageNow != null){
            pages = new Page(totalCount, Integer.parseInt(pageNow));
            list = pageDAO.selectTopEmployeeByPage(pages.getStartPos(), pages.getPageSize());
        }else{
            pages = new Page(totalCount, 1);
            list = pageDAO.selectTopEmployeeByPage(pages.getStartPos(), pages.getPageSize());

        }

        request.setAttribute("list", list);
        request.setAttribute("pages", pages);

    }

    @Override
    public void showStudioByPage(HttpServletRequest request, String pageNow) {

        Page pages = null;
        List<Studio> list = new ArrayList<Studio>();
        int totalCount = (int)pageDAO.getStudioCount();

        if(pageNow != null){
            pages = new Page(totalCount, Integer.parseInt(pageNow));
            list = pageDAO.selectStudioByPage(pages.getStartPos(), pages.getPageSize());
        }else{
            pages = new Page(totalCount, 1);
            list = pageDAO.selectStudioByPage(pages.getStartPos(), pages.getPageSize());

        }

        request.setAttribute("list", list);
        request.setAttribute("pages", pages);

    }

    @Override
    public void showPlayByPage(HttpServletRequest request, String pageNow) {

        Page pages = null;
        List<Play> list = new ArrayList<Play>();
        int totalCount = (int)pageDAO.getPlayCount();

        if(pageNow != null){
            pages = new Page(totalCount, Integer.parseInt(pageNow));
            list = pageDAO.selectPlayByPage(pages.getStartPos(), pages.getPageSize());
        }else{
            pages = new Page(totalCount, 1);
            list = pageDAO.selectPlayByPage(pages.getStartPos(), pages.getPageSize());

        }

        request.setAttribute("list", list);
        request.setAttribute("pages", pages);

    }

    @Override
    public void showNoticeByPage(HttpServletRequest request, String pageNow) {

        Page pages = null;
        List<Notice> list = new ArrayList<Notice>();
        int totalCount = (int)pageDAO.getNoticeCount();

        if(pageNow != null){
            pages = new Page(totalCount, Integer.parseInt(pageNow));
            list = pageDAO.selectNoticeByPage(pages.getStartPos(), pages.getPageSize());
        }else{
            pages = new Page(totalCount, 1);
            list = pageDAO.selectNoticeByPage(pages.getStartPos(), pages.getPageSize());

        }

        request.setAttribute("list", list);
        request.setAttribute("pages", pages);

    }
}
