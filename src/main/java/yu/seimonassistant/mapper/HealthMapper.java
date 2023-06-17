package yu.seimonassistant.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import yu.seimonassistant.entity.Health;

@Repository
public interface HealthMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Health row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Health selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Health> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Health row);
}