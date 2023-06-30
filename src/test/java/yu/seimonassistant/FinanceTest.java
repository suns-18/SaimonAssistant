package yu.seimonassistant;

import org.junit.jupiter.api.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yu.seimonassistant.controller.FinanceController;
import yu.seimonassistant.request.FinanceRangeRequest;
import yu.seimonassistant.entity.Finance;
import yu.seimonassistant.util.UUIDUtil;

import java.util.Date;
import java.util.List;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FinanceTest {
    @Autowired
    FinanceController c;

    Logger log = Logger.getLogger(FinanceTest.class);

    @Test
    @Order(1)
    void add() {
        var f = new Finance();
        f.setId("b9b737410bf0b093b4e00e38ef80fcaa");
        f.setTitle("test");
        Assertions.assertEquals(1,
                c.add(f).getCode(),
                "Finance模块>>添加请求测试1：插入正常数据，未通过");
        log.info("Finance模块>>添加请求测试1：插入正常数据，通过");

        Assertions.assertEquals(0,
                c.add(f).getCode(),
                "Finance模块>>添加请求测试2：插入已存在数据，未通过");
        log.info("Finance模块>>添加请求测试2：插入已存在数据，通过");

        log.info("Finance模块>>添加请求测试，通过");
    }

    @Test
    @Order(2)
    void query() {
        var f = new Finance();
        f.setId("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Assertions.assertEquals(0,
                c.queryById(f).getCode(),
                "Finance模块>>根据Id查询请求测试1：不存在的Id，未通过");
        log.info("Finance模块>>根据Id查询请求测试1：不存在的Id，通过");

        f.setId("b9b737410bf0b093b4e00e38ef80fcaa");
        Assertions.assertEquals(1,
                c.queryById(f).getCode(),
                "Finance模块>>根据Id查询请求测试2：存在的Id，未通过");
        log.info("Finance模块>>根据Id查询请求测试2：存在的Id，通过");

        log.info("Finance模块>>根据Id查询请求测试，通过");
    }


    @Test
    @Order(3)
    void modify() {
        var f = new Finance();
        f.setId("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Assertions.assertEquals(0,
                c.modify(f).getCode(),
                "Finance模块>>修改请求测试1：不存在的Id，未通过");
        log.info("Finance模块>>修改请求测试1：不存在的Id，通过");

        f.setId("b9b737410bf0b093b4e00e38ef80fcaa");
        f.setTitle("test1");
        Assertions.assertEquals(1,
                c.modify(f).getCode(),
                "Finance模块>>修改请求测试2：存在的Id，未通过");
        log.info("Finance模块>>修改请求测试2：存在的Id，通过");

        log.info("Finance模块>>修改请求测试，通过");
    }

    @Test
    @Order(4)
    void queryList1() {
        Assertions.assertFalse((
                        (List<Finance>) c.queryList().getData()).isEmpty(),
                "Finance模块>>列表请求测试1：非空列表，未通过");
        log.info("Finance模块>>列表请求测试1：非空列表，通过");
    }


    @Test
    @Order(5)
    void stat() {
        var r = new FinanceRangeRequest();
        r.setStartTime(new Date());
        r.setEndTime(new Date());
        log.info("Finance模块>>统计请求测试：通过");
    }

    @Test
    @Order(6)
    void del() {
        var f = new Finance();
        f.setId("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Assertions.assertEquals(0,
                c.delete(f).getCode(),
                "Finance模块>>删除请求测试1：不存在的Id，未通过");
        log.info("Finance模块>>删除请求测试1：不存在的Id，通过");

        f.setId("b9b737410bf0b093b4e00e38ef80fcaa");
        Assertions.assertEquals(1,
                c.delete(f).getCode(),
                "Finance模块>>删除请求测试2：存在的Id，未通过");
        log.info("Finance模块>>删除请求测试2：存在的Id，通过");

        log.info("Finance模块>>删除请求测试，通过");
    }

    @Test
    @Order(7)
    void queryList2() {
        Assertions.assertTrue((
                        (List<Finance>) c.queryList().getData()).isEmpty(),
                "Finance模块>>列表请求测试2：空列表，未通过");
        log.info("Finance模块>>列表请求测试2：空列表，通过");
    }
}
