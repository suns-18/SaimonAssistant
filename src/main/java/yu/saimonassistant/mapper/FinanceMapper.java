package yu.saimonassistant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yu.saimonassistant.entity.Finance;

@Mapper
public interface FinanceMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Finance row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Finance selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Finance> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Finance row);
}