package yu.seimonassistant.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import yu.seimonassistant.entity.Investment;

@Repository
public interface InvestmentMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Investment row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Investment selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Investment> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Investment row);
}