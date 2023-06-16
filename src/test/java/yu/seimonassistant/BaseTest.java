package yu.seimonassistant;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import yu.seimonassistant.util.UUIDUtil;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseTest {
	@Test
	void uuidsUtilTest() {
		UUIDUtil.getUUID(0);
		UUIDUtil.getUUID(1);
		UUIDUtil.getUUID(2);
	}
}
