package yu.seimonassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yu.seimonassistant.response.HttpResponse;
import yu.seimonassistant.entity.UserInfo;
import yu.seimonassistant.service.UserInfoService;

@RestController
@RequestMapping(value = "/api/user")
public class UserInfoController {
	@Autowired
	private UserInfoService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public HttpResponse userLogin(@RequestBody UserInfo user) {
		if (user == null || user.getUsername() == null)
			return new HttpResponse(
				0, null, "参数错误");

		try {
			var result = service.verifyUser(user);
			if (result == null)
				return new HttpResponse(
					0, null, "登陆失败，用户名或密码错误");

			return new HttpResponse(1, result, "登陆成功");
		} catch (Exception e) {
			return new HttpResponse(0, null, "数据库访问出错");
		}
	}
}
