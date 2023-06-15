package yu.saimonassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.saimonassistant.mapper.UserInfoMapper;
import yu.saimonassistant.entity.UserInfo;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoMapper mapper;
	public UserInfo verifyUser(UserInfo user) {
		return mapper.selectByLoginInfo(user);
	}
}
