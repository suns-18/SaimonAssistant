package yu.seimonassistant.mapper;

import org.apache.ibatis.annotations.Mapper;
import yu.seimonassistant.entity.Reserve;

import java.util.List;

@Mapper
public interface ReserveMapper {
    int insert(Reserve row);

    int deleteById(String id);

    int update(Reserve row);

    Reserve selectById(String id);

    List<Reserve> selectAll();
}