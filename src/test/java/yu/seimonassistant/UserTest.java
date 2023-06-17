package yu.seimonassistant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yu.seimonassistant.controller.UserInfoController;
import yu.seimonassistant.response.HttpResponse;
import yu.seimonassistant.entity.UserInfo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserTest {
	@Autowired
	UserInfoController c;

	@Test
	void login() {
		HttpResponse resp;
		Assertions.assertNull(c.userLogin(new UserInfo()).getData(),
			"登陆失败用例1");
		System.out.println("[INFO] >>登陆失败用例1通过");

		var u = new UserInfo();
		u.setPassword(null);
		u.setUsername(null);
		resp = c.userLogin(u);
		Assertions.assertNull(resp.getData(),
			"参数错误用例1，返回消息：" + resp.getMsg());
		System.out.println("[INFO] >>参数错误用例1通过");

		u.setPassword("a");
		u.setUsername("a");
		resp = c.userLogin(u);
		Assertions.assertNotNull(resp.getData(),
			"登陆成功用例，返回消息：" + resp.getMsg());
		System.out.println("[INFO] >>登陆成功用例1通过");

		resp = c.userLogin(null);
		Assertions.assertNull(resp.getData(),
			"参数错误用例2，返回消息：" + resp.getMsg());
		System.out.println("[INFO] >>参数错误用例2通过");

		char[] longName = new char[512];
		for (int i = 0; i < 511; i++) {
			longName[i] = 'a';
		}
		u.setUsername(new String(
			longName
		));
		resp = c.userLogin(u);
		Assertions.assertNull(resp.getData(),
			"参数错误用例3，返回消息：" + resp.getMsg());
		System.out.println("[INFO] >>参数错误用例3通过");
		System.out.println("[INFO] >>用户登陆功能白盒测试通过");

	}
}
