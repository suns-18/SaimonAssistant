package yu.seimonassistant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import yu.seimonassistant.entity.Volunteer;

@Mapper
public interface VolunteerMapper {
    int insert(Volunteer row);
    int deleteById(String id);
    int update(Volunteer row);
    Volunteer selectById(String id);
    List<Volunteer> selectAll();
}