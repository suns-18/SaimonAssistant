package yu.seimonassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yu.seimonassistant.entity.Investment;
import yu.seimonassistant.response.HttpResponse;
import yu.seimonassistant.service.InvestService;

@RestController
@RequestMapping("/api/invest")
public class InvestController {
    @Autowired
    private InvestService service;

    @PostMapping("/add")
    public HttpResponse add(
            @RequestBody Investment investment) {
        int result;
        try {
            result = service.insert(investment);
            if (result == 0)
                return new HttpResponse(0, result, "添加失败");
            else
                return new HttpResponse(1, result, "添加成功");

        } catch (Exception e) {
            return new HttpResponse(0, -1, "数据库访问错误");
        }
    }

    @PostMapping("/delete")
    public HttpResponse delete(
            @RequestBody Investment investment) {
        int result;
        try {
            result = service.delele(investment);
            if (result == 0)
                return new HttpResponse(0, result, "添加失败");
            else
                return new HttpResponse(1, result, "添加成功");

        } catch (Exception e) {
            return new HttpResponse(0, -1, "数据库访问错误");
        }
    }

    @PostMapping("/modify")
    public HttpResponse modify(
            @RequestBody Investment investment) {
        int result;
        try {
            result = service.update(investment);
            if (result == 0)
                return new HttpResponse(0, result, "修改失败");
            else
                return new HttpResponse(1, result, "修改成功");

        } catch (Exception e) {
            return new HttpResponse(0, -1, "数据库访问错误");
        }
    }

    @PostMapping("/queryById")
    public HttpResponse queryById(
            @RequestBody Investment investment) {
        try {
            var result = service.selectById(investment);
            if (result == null)
                return new HttpResponse(0, null, "不存在");
            else
                return new HttpResponse(1, result, "查询成功");
        } catch (Exception e) {
            return new HttpResponse(0, null, "数据库访问错误");
        }
    }

    @PostMapping("/queryList")
    public HttpResponse queryList() {
        try {
            var result = service.selectAll();
            if (result.isEmpty())
                return new HttpResponse(1, result, "查询成功，列表为空");
            else
                return new HttpResponse(1, result, "查询成功");
        } catch (Exception e) {
            return new HttpResponse(0, null, "数据库访问错误");
        }

    }

}