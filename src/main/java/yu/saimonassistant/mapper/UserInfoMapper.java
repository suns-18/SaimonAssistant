package yu.saimonassistant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yu.saimonassistant.entity.UserInfo;

@Repository
@Mapper
public interface UserInfoMapper {
    int insert(UserInfo row);
    int deleteByPrimaryKey(String id);
    int updateByPrimaryKey(UserInfo row);
    UserInfo selectByLoginInfo(UserInfo row);
    UserInfo selectById(String id);
    List<UserInfo> selectAll();
}