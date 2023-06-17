package yu.seimonassistant.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import yu.seimonassistant.entity.Volunteer;

@Repository
public interface VolunteerMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Volunteer row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Volunteer selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Volunteer> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Volunteer row);
}