package com.ttms.dao;

import com.ttms.entity.Studio;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hjh on 16-12-5.
 */
@Repository("StudioDAO")
public interface StudioDAO {

    public void insertStudio(Studio studio);
    public void deleteStudio(int studio_id);
    public void updateStudio(Studio studio);

    public Studio selectStudioByStudio_id(int studio_id);
    public Studio selectStudioByStudio_name(String studio_name);
    public List<Studio> selectStudioByStudio_flag(int studio_flag);
    public List<Studio> selectStudio();
    public List<Studio> selectSpecialStudio(int studio_id);


}
