package yu.seimonassistant;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yu.seimonassistant.controller.ReserveController;
import yu.seimonassistant.entity.Reserve;
import java.util.List;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReserveTest {
    @Autowired
    ReserveController c;

    Logger log = Logger.getLogger(ReserveTest.class);

    @Test
    @Order(1)
    void add() {
        var reserve = new Reserve();
        reserve.setId("b9b737410bf0b093b4e00e38ef80fcaa");
        Assertions.assertEquals(0,
                c.add(reserve).getCode(),
                "Finance模块>>添加请求测试1：标题为空，未通过");
        log.info("Finance模块>>添加请求测试1：标题为空，通过");

        reserve.setTitle("test");
        Assertions.assertEquals(1,
                c.add(reserve).getCode(),
                "Finance模块>>添加请求测试2：正常数据，未通过");
        log.info("Finance模块>>添加请求测试2：正常数据，通过");

        Assertions.assertEquals(0,
                c.add(reserve).getCode(),
                "Finance模块>>添加请求测试3：插入已存在数据，未通过");
        log.info("Finance模块>>添加请求测试3：插入已存在数据，通过");

        log.info("Finance模块>>添加请求测试，通过");
    }

    @Test
    @Order(2)
    void query() {
        var reserve = new Reserve();
        reserve.setId("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Assertions.assertEquals(0,
                c.queryById(reserve).getCode(),
                "Reserve模块>>根据Id查询请求测试1：不存在的Id，未通过");
        log.info("Reserve模块>>根据Id查询请求测试1：不存在的Id，通过");

        reserve.setId("b9b737410bf0b093b4e00e38ef80fcaa");
        Assertions.assertEquals(1,
                c.queryById(reserve).getCode(),
                "Reserve模块>>根据Id查询请求测试2：存在的Id，未通过");
        log.info("Reserve模块>>根据Id查询请求测试2：存在的Id，通过");

        log.info("Reserve模块>>根据Id查询请求测试，通过");
    }


    @Test
    @Order(3)
    void modify() {
        var reserve = new Reserve();
        reserve.setId("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Assertions.assertEquals(0,
                c.modify(reserve).getCode(),
                "Reserve模块>>修改请求测试1：不存在的Id，未通过");
        log.info("Reserve模块>>修改请求测试1：不存在的Id，通过");

        reserve.setId("b9b737410bf0b093b4e00e38ef80fcaa");
        reserve.setTitle("test1");
        Assertions.assertEquals(1,
                c.modify(reserve).getCode(),
                "Reserve模块>>修改请求测试2：存在的Id，未通过");
        log.info("Reserve模块>>修改请求测试2：存在的Id，通过");

        log.info("Reserve模块>>修改请求测试，通过");
    }

    @Test
    @Order(4)
    void queryList1() {
        Assertions.assertFalse((
                        (List<Reserve>) c.queryList().getData()).isEmpty(),
                "Reserve模块>>列表请求测试1：非空列表，未通过");
        log.info("Reserve模块>>列表请求测试1：非空列表，通过");
    }

    @Test
    @Order(5)
    void del() {
        var reserve = new Reserve();
        reserve.setId("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Assertions.assertEquals(0,
                c.delete(reserve).getCode(),
                "Reserve模块>>删除请求测试1：不存在的Id，未通过");
        log.info("Reserve模块>>删除请求测试1：不存在的Id，通过");

        reserve.setId("b9b737410bf0b093b4e00e38ef80fcaa");
        Assertions.assertEquals(1,
                c.delete(reserve).getCode(),
                "Reserve模块>>删除请求测试2：存在的Id，未通过");
        log.info("Reserve模块>>删除请求测试2：存在的Id，通过");

        log.info("Reserve模块>>删除请求测试，通过");
    }

    @Test
    @Order(6)
    void queryList2() {
        Assertions.assertTrue((
                        (List<Reserve>) c.queryList().getData()).isEmpty(),
                "Reserve模块>>列表请求测试2：空列表，未通过");
        log.info("Reserve模块>>列表请求测试2：空列表，通过");
    }
}
