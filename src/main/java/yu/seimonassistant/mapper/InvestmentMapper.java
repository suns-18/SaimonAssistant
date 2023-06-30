package yu.seimonassistant.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import yu.seimonassistant.entity.Investment;

@Repository
public interface InvestmentMapper {
    int insert(Investment row);
    int deleteById(String id);
    int update(Investment row);
    Investment selectById(String id);
    List<Investment> selectAll();
    
}