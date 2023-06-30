package yu.seimonassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.seimonassistant.entity.Volunteer;
import yu.seimonassistant.mapper.VolunteerMapper;
import yu.seimonassistant.util.UUIDUtil;

import java.util.List;

@Service
public class VolunteerService {
    @Autowired
    private VolunteerMapper mapper;

    public int insert(Volunteer volunteer) {
        if(volunteer.getId().isEmpty())
            volunteer.setId(UUIDUtil.getOneUUID());
        return mapper.insert(volunteer);
    }

    public int deleteById(Volunteer volunteer){
        return mapper.deleteById(volunteer.getId());
    }

    public int update(Volunteer volunteer){
        return mapper.update(volunteer);
    }

    public Volunteer selectById(Volunteer volunteer){
        return mapper.selectById(
                volunteer.getId());
    }

    public List<Volunteer> selectAll(){
        return mapper.selectAll();
    }
}
