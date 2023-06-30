package yu.seimonassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.seimonassistant.entity.Reserve;
import yu.seimonassistant.mapper.ReserveMapper;
import yu.seimonassistant.util.UUIDUtil;

import java.util.List;

@Service
public class ReserveService {
    @Autowired
    private ReserveMapper reserveMapper;

    public int insert(Reserve reserve){
        if(reserve.getId()==null || reserve.getId().isEmpty())
            reserve.setId(UUIDUtil.getOneUUID());
        return reserveMapper.insert(reserve);
    }
    public int deleteById(Reserve reserve) {
        return reserveMapper.deleteById(reserve.getId());
    }

    public int update(Reserve reserve){ return reserveMapper.update(reserve); }

    public List<Reserve> selectAll(){
        return reserveMapper.selectAll();
    }

    public Reserve selectById(Reserve reserve){
        return reserveMapper.selectById(reserve.getId());
    }
}
