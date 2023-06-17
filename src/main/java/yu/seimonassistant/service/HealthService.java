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

    public int deleteById(Health health) {
        return healthMapper.deleteByPrimaryKey(health.getId());
    }

    public int modifyHealthInfo(Health health){ return healthMapper.updateByPrimaryKey(health); }

    public int addHealthInfo(Health health){
        // 插入前生成ID
        health.setId(UUIDUtil.getOneUUID());
        return healthMapper.insert(health);
    }

    public List<Health> queryHealthList(){
        return healthMapper.selectAll();
    }

    public Health selectById(Health health){
        return healthMapper.selectByPrimaryKey(health.getId());
    }

}
