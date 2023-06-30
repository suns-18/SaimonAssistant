package yu.seimonassistant.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import yu.seimonassistant.entity.Health;

@Repository
public interface HealthMapper {
    int insert(Health row);
    int deleteById(String id);
    int update(Health row);
    Health selectById(String id);
    List<Health> selectAll();
}