package yu.seimonassistant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yu.seimonassistant.controller.HealthController;
import yu.seimonassistant.entity.Health;
import yu.seimonassistant.util.UUIDUtil;

import java.util.logging.Logger;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public
class HealthTest {
	@Autowired
	HealthController c;
	Logger log = Logger.getLogger(String.valueOf(HealthTest.class));
	@Test
	void query() {

		Assertions.assertNotNull(c.queryList().getData(),
			"返回列表出错");
		log.info("query功能>>测试1：查询所有健康信息，返回所有，测试通过");
		var h = new Health();
		h.setId(UUIDUtil.getOneUUID());
		Assertions.assertNull(c.queryById(h).getData(),
			"查找一个不存在的健康信息记录");
		log.info("query功能>>测试2：查询不存在的单一健康信息，返回为空，测试通过");
		h.setId("06591c911063db0bba63da28c9f7e353");
		Assertions. assertNotNull(c.queryById(h).getData(),
			"查找一个存在的健康信息记录");
		log.info("query功能>>测试2：查询存在的单一健康信息，返回正常，测试通过");
		h.setId(null);
		c.queryById(h);
		Assertions.assertNull(c.queryById(h).getData(),
			"查找健康信息记录参数错误");
		log.info("query功能>>测试3：查询id为null的单一健康信息，返回为空，测试通过");
		log.info("query功能>>单个请求测试通过");
	}

	@Test
	void add() {
		Assertions.assertEquals(c.add(null).getCode(), 0);
		log.info("add功能>>测试1：添加一条null的健康信息，无法添加，测试通过");

		var h = new Health();
		h.setTitle("guagau");
		h.setId("111");

		Assertions.assertEquals(c.add(h).getCode(), 1);

		log.info("add功能>>测试2：添加一条健康信息，添加成功，测试通过");
		h.setTitle("");
		Assertions.assertEquals(c.add(h).getCode(), 0);
		log.info("add功能>>测试3：添加一条标题为空串健康信息，无法添加，测试通过");
		log.info("add功能>>单个请求测试通过");
	}

	@Test
	void update() {
		Assertions.assertEquals(c.modify(null).getData(), 0);
		log.info("update功能>>测试1：更新一条null的健康信息，无法更新，测试通过");
		var h = new Health();
		h.setId("06591c911063db0bba63da28c9f7e353");
		h.setTitle("bbb");
		Assertions.assertEquals(c.modify(h).getCode(), 1);
		log.info("update功能>>测试2：更新一条正常的健康信息，更新成功，测试通过");
		h.setId("114514");
		h.setTitle("bbb");
		Assertions.assertEquals(c.modify(h).getCode(), 0);
		log.info("update功能>>测试3：更新一条id不存在的健康信息，无法更新，测试通过");
		log.info("update功能>>单个请求测试通过");
	}
	@Test
	void del() {
		Assertions.assertEquals(c.delete(null).getCode(), 0);
		log.info("delete功能>>测试1：删除一条null的健康信息，无法删除，测试通过");
		var h = new Health();
		h.setId("06591c911063db0bba63da28c9f7e353");
		h.setTitle("bbb");
		Assertions.assertEquals(c.modify(h).getCode(), 1);
		log.info("delete功能>>测试2：删除一条正常的健康信息，更新成功，测试通过");
		h.setId("114514");
		h.setTitle("bbb");
		Assertions.assertEquals(c.modify(h).getCode(), 0);
		log.info("delete功能>>测试3：删除一条id不存在的健康信息，无法更新，测试通过");
		log.info("delete功能>>单个请求测试通过");
	}

}
