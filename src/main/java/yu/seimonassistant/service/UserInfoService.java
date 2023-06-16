package yu.seimonassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.seimonassistant.mapper.UserInfoMapper;
import yu.seimonassistant.entity.UserInfo;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoMapper mapper;
	public UserInfo verifyUser(UserInfo user) {
		return mapper.selectByLoginInfo(user);
	}
}
