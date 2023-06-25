package yu.seimonassistant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yu.seimonassistant.controller.FinanceController;
import yu.seimonassistant.request.FinanceRangeRequest;
import yu.seimonassistant.entity.Finance;
import yu.seimonassistant.util.UUIDUtil;

import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public
class FinanceTest {
	@Autowired
	FinanceController c;

	@Test
	void query() {

		Assertions.assertNotNull(c.queryList().getData(),
			"返回列表");

		var f = new Finance();
		f.setId(UUIDUtil.getOneUUID());
		Assertions.assertNull(c.queryById(f).getData(),
			"查找一个不存在的开支记录");

		f.setId("0127d8a43700dfa784ef5ba41bd35500");
		Assertions.assertNotNull(c.queryById(f).getData(),
			"查找一个存在的开支记录");

		f.setId(null);
		c.queryById(f);
		Assertions.assertNull(c.queryById(f).getData(),
			"查找开支记录参数错误");
	}

	@Test
	void add() {
		Assertions.assertEquals(c.add(null).getCode(), 0);

		var f = new Finance();
		f.setTitle("aaa");
		Assertions.assertEquals(c.add(f).getCode(), 1);
	}

	@Test
	void update() {
		Assertions.assertEquals(c.modify(null).getData(), 0);

		var f = new Finance();
		f.setId("0127d8a43700dfa784ef5ba41bd35500");
		f.setTitle("bbb");
		Assertions.assertEquals(c.modify(f).getCode(), 1);

		f.setId("114514");
		f.setTitle("bbb");
		Assertions.assertEquals(c.modify(f).getCode(), 0);
	}

	@Test
	void stat() {
		var r = new FinanceRangeRequest();
		r.setStartTime(new Date());
		r.setEndTime(new Date());
		System.out.println(c.queryStat(r));
	}
}
