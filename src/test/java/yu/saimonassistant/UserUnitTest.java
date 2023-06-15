package yu.saimonassistant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yu.saimonassistant.controller.UserInfoController;
import yu.saimonassistant.entity.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserUnitTest {
	@Autowired
	private UserInfoController c;
	@Test
	public void loginTest(){
		c.userLogin(new UserInfo());

		var u = new UserInfo();
		u.setPassword(null);
		u.setUsername(null);
		c.userLogin(u);

		u.setPassword("a");
		u.setUsername("a");
		c.userLogin(u);
	}
}
