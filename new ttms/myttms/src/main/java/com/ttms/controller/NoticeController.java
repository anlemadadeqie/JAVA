package com.ttms.controller;

import com.ttms.entity.Notice;
import com.ttms.entity.Page;
import com.ttms.service.NoticeService;
import com.ttms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hjh on 16-12-10.
 */
@Controller("NoticeController")
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;
    @Autowired
    PageService pageService;

    @RequestMapping("/shownotice")
    public ModelAndView showNoticePage(HttpServletRequest request){


        String pageNow = request.getParameter("pageNow");
        pageService.showNoticeByPage(request, pageNow);
        return  new ModelAndView("/manager/notice/Notice");
    }


    @RequestMapping("/changeshow")
    public ModelAndView changeShowNoticePage(HttpServletRequest request){

        String pageNow = request.getParameter("pageNow");
        pageService.showNoticeByPage(request, pageNow);
        return  new ModelAndView("/manager/notice/ChangeNotice");
    }


    @RequestMapping("/addnotice")
    public ModelAndView addNoticePage(HttpServletRequest request){

        String notice_title = request.getParameter("noticename");
        String notice_content = request.getParameter("noticeintro");
        noticeService.addNotice(notice_title, notice_content);
        request.setAttribute("errors","添加成功！");

        return new ModelAndView("/manager/notice/AddNotice");
    }


    @RequestMapping("/updatenotice")
    public ModelAndView updateNoticePage(HttpServletRequest request){

        String notice_id = request.getParameter("id");
        String notice_title = request.getParameter("noticename");
        String notice_content = request.getParameter("noticeintro");
        noticeService.changeNotice(notice_id, notice_title, notice_content);

        return changeShowNoticePage(request);
    }


    @RequestMapping("/delnotice")
    public ModelAndView delNoticePage(HttpServletRequest request){


        String[] checkbox = request.getParameterValues("type");
        if(checkbox != null) {
            for (int i = 0; i < checkbox.length; i++) {
                String id = checkbox[i];
                int notice_id = Integer.parseInt(id);
                noticeService.deleteNotice(notice_id);

            }
        }
        return changeShowNoticePage(request);


    }


    @RequestMapping("/noticedetail")
    public ModelAndView noticeDetailPage(HttpServletRequest request){

        String id = request.getParameter("id");
        int notice_id = Integer.parseInt(id);
        Notice notice = noticeService.selectNoticeByNotice_id(notice_id);
        request.setAttribute("notice", notice);
        return new ModelAndView("/manager/notice/NoticeDetail");
    }


    @RequestMapping("/editnotice")
    public ModelAndView editNoticePage(HttpServletRequest request){

        String id = request.getParameter("id");
        int notice_id = Integer.parseInt(id);
        Notice notice = noticeService.selectNoticeByNotice_id(notice_id);
        request.setAttribute("notice", notice);
        return new ModelAndView("/manager/notice/UpdateNotice");
    }
}
