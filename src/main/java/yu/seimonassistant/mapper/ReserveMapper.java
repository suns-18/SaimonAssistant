package yu.seimonassistant.mapper;

import org.apache.ibatis.annotations.Mapper;
import yu.seimonassistant.entity.Reserve;

import java.util.List;

@Mapper
public interface ReserveMapper {
    int deleteByPrimaryKey(String id);
    int insert(Reserve row);
    Reserve selectByPrimaryKey(String id);
    List<Reserve> selectAll();
    int updateByPrimaryKey(Reserve row);
}