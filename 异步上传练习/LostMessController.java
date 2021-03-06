package com.web.controller;

import com.web.entity.Lostmess;
import com.web.service.LostActionService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by shiyi on 2016/12/16.
 * 丢失信息类
 */

@Controller("LostMessController")
@RequestMapping("/lostmess")
public class LostMessController {

    @Autowired
    private LostActionService lostActionService;

    //信息列表
    @RequestMapping("list")
    public ModelAndView showMoreLostMess()
    {
        ModelAndView mdv = new ModelAndView("lostlist");

        List<Lostmess> lostList = lostActionService.getLostMess(0, 12);
        mdv.addObject("lostList", lostList);

        int lostNum = lostActionService.getLostMessCount();
        mdv.addObject("lostMessCount", lostNum);


        System.out.println(lostNum);

        return mdv;
    }

    //信息详情页
    @RequestMapping("{lostId}")
    public ModelAndView showOneLostMess(@PathVariable int lostId)
    {

        ModelAndView mdv = new ModelAndView("lostmess");
        Lostmess lostmess = lostActionService.getLostMessById(lostId);

        mdv.addObject("lostmess", lostmess);

        return mdv;
    }

    @RequestMapping("/uploads")
    public String uploads(HttpServletRequest request){

        return "uploadlost";
    }


    @RequestMapping("/upload")
    public ModelAndView uploadLostMess(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ServletFileUpload sfu = lostActionService.getFileData();
        List<FileItem> list = sfu.parseRequest(request);

        String path = request.getServletContext().getRealPath("/");
        path += "WEB-INF/static/picture";
        String load = lostActionService.uploadLostMess(list, path);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(load);

        return null;

    }

    @RequestMapping("/add")
    public ModelAndView addLostMess(HttpServletRequest request) throws IOException {

        int user_id = 0;
        String data = request.getParameter("data");
        System.out.println(data);
        JSONObject object = new JSONObject(data);
        String name = object.getString("name");
        int sex = object.getInt("sex");
        int height = object.getInt("height");
        String birthday = object.getString("birthday");
        String native_place = object.getString("native_place");
        int blood_type = object.getInt("blood_type");
        String lost_place = object.getString("lost_place");
        String lost_date = object.getString("lost_date");
        String picture_list = object.getString("picture_list");
        String feature = object.getString("feature");
        int find_type = object.getInt("find_type");
        String other_message = object.getString("other_message");

        boolean result = lostActionService.addLostMess(name, sex, height, birthday, native_place,
                blood_type, lost_place, lost_date, picture_list, feature, find_type, other_message, user_id);

        return null;
    }
}
