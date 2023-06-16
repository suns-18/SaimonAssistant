package yu.seimonassistant.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import yu.seimonassistant.entity.Finance;

@Mapper
public interface FinanceMapper {
    int deleteByPrimaryKey(String id);
    int insert(Finance row);
    Finance selectByPrimaryKey(String id);
    List<Finance> selectByDuration(Date startTime, Date endTime);
    List<Finance> selectAll();
    int updateByPrimaryKey(Finance row);

}