package yu.seimonassistant.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import yu.seimonassistant.entity.Finance;

@Mapper
public interface FinanceMapper {
    int insert(Finance row);

    int deleteById(String id);

    int update(Finance row);

    Finance selectById(String id);

    List<Finance> selectBetweenDuration(
            Date startTime, Date endTime);

    List<Finance> selectAll();
}