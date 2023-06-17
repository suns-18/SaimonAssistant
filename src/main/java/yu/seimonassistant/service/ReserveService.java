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

    public int deleteById(Reserve reserve) {
        return reserveMapper.deleteByPrimaryKey(reserve.getId());
    }

    public int modifyReserveInfo(Reserve reserve){ return reserveMapper.updateByPrimaryKey(reserve); }

    public int addReserveInfo(Reserve reserve){
        // 插入前生成ID
        reserve.setId(UUIDUtil.getOneUUID());
        return reserveMapper.insert(reserve);
    }

    public List<Reserve> queryReserveList(){
        return reserveMapper.selectAll();
    }

    public Reserve selectById(Reserve reserve){
        return reserveMapper.selectByPrimaryKey(reserve.getId());
    }
}
