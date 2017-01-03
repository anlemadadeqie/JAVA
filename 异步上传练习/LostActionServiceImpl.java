package com.web.serviceImpl;

import com.web.dao.LostmessDAO;
import com.web.dao.LostrecordDAO;
import com.web.entity.Gaminmess;
import com.web.entity.Gaminrecord;
import com.web.entity.Lostmess;
import com.web.entity.Lostrecord;
import com.web.service.LostActionService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shiyi on 2016/12/19.
 */
@Service("LostActionService")
public class LostActionServiceImpl implements LostActionService{

    @Autowired
    private LostmessDAO lostmessDAO;
    @Autowired
    private LostrecordDAO lostrecordDAO;

    public int getLostMessCount() {

        return lostmessDAO.selectLostmessCount();
    }

    public List getLostMess(int start, int num) {

        List<Lostmess> lostmessList = lostmessDAO.selectLostmess(new Lostmess(), start, num);
        return lostmessList;
    }

    public Lostmess getLostMessById(int id) {
        return lostmessDAO.selectLostmessFromId(id);
    }

    public Lostmess getLostMessByName(String name) {

        return null;
    }

    public ServletFileUpload getFileData() {

        DiskFileItemFactory dff = new DiskFileItemFactory();
        dff.setSizeThreshold(1024000);
        ServletFileUpload sfu = new ServletFileUpload(dff);
        sfu.setFileSizeMax(1024*1024*2);
        return sfu;

    }

    public String uploadLostMess(List<FileItem> uploaditems, String path) {

        String load = "";
        Iterator<FileItem> item = uploaditems.iterator();
        while (item.hasNext()) {

            FileItem fi = (FileItem) item.next();
            String fileName = fi.getName();

            if (fileName != null) {

                File fullFile = null;
                try {
                    fullFile = new File(new String(fi.getName().getBytes(), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                File file = new File(path, fullFile.getName());
                load = "/picture/" + fullFile.getName();
                try {
                    fi.write(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return load;

    }

    public boolean addLostMess(String name, int sex, int height, String birthady, String native_place, int blood_type, String lost_place, String lost_date, String picture_list, String feature, int find_type, String other_message, int user_id) {

        boolean result = false;
        Lostmess lostmess = new Lostmess();
        lostmess.setName(name);
        lostmess.setSex(sex);
        lostmess.setHeight(height);
        lostmess.setBirthday(birthady);
        lostmess.setNative_place(native_place);
        lostmess.setBlood_type(blood_type);
        lostmess.setLost_place(lost_place);
        lostmess.setLost_date(lost_date);
        lostmess.setPicture_list(picture_list);
        lostmess.setFeature(feature);
        lostmess.setFind_type(find_type);
        lostmess.setOther_message(other_message);
        lostmessDAO.insertLostmess(lostmess);
        System.out.println("aaaaaa");
        int lost_id = lostmess.getId();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pubdate = formats.format(cal.getTime());
        Lostrecord lostrecord = new Lostrecord();
        lostrecord.setLost_id(lost_id);
        lostrecord.setUser_id(user_id);
        lostrecord.setFind_status(0); //0：未找到　１：找到
        lostrecord.setPubdate(pubdate);
        lostrecordDAO.insertLostrecord(lostrecord);
        result = true;

        return  result;


    }


}
