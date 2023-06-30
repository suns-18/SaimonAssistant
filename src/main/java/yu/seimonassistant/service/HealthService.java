package yu.seimonassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.seimonassistant.entity.Health;
import yu.seimonassistant.mapper.HealthMapper;
import yu.seimonassistant.util.UUIDUtil;

import java.util.List;

@Service
public class HealthService {
    @Autowired
    private HealthMapper healthMapper;

    public int insert(Health health) {
        if (health.getId() == null
                || health.getId().isEmpty())
            health.setId(UUIDUtil.getOneUUID());
        return healthMapper.insert(health);
    }

    public int deleteById(Health health) {
        return healthMapper.deleteById(health.getId());
    }

    public int update(Health health) {
        return healthMapper.update(health);
    }

    public List<Health> queryList() {
        return healthMapper.selectAll();
    }

    public Health selectById(Health health) {
        return healthMapper.selectById(health.getId());
    }

}
