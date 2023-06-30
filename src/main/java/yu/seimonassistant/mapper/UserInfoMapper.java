package yu.seimonassistant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yu.seimonassistant.entity.UserInfo;

@Repository
@Mapper
public interface UserInfoMapper {
    int insert(UserInfo row);
    int deleteById(String id);
    int update(UserInfo row);
    UserInfo selectByLoginInfo(UserInfo row);
    UserInfo selectById(String id);
    List<UserInfo> selectAll();
}