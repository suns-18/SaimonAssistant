package yu.seimonassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yu.seimonassistant.entity.Reserve;
import yu.seimonassistant.response.HttpResponse;
import yu.seimonassistant.service.ReserveService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reserve")
public class ReserveController {
    @Autowired
    private ReserveService reserveService;

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public HttpResponse deleteReserve(@RequestBody Reserve reserve) {
        int result = -1;
        try {
            result =reserveService.deleteById(reserve);
            if (result == 0)
                return new HttpResponse(0, result, "删除失败");
            else
                return new HttpResponse(1, result, "删除成功");
        } catch (Exception e) {
            return new HttpResponse(0, result, "请求错误");
        }
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public HttpResponse modifyReserve(@RequestBody Reserve reserve) {
        int result = -1;
        result = reserveService.modifyReserveInfo(reserve);
        try {
            if (result == 0)
                return new HttpResponse(0, result, "修改失败");
            else
                return new HttpResponse(1, result, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpResponse(0, result, "请求错误");
        }
    }

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    public HttpResponse queryReserveList() {
        try {
            List<Reserve> result = reserveService.queryReserveList();
            if (result.isEmpty())
                return new HttpResponse(1, result, "储蓄记录为空");
            else
                return new HttpResponse(1, result, "查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpResponse(0, null, "请求错误");
        }
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public HttpResponse queryReserve(@RequestBody Reserve reserve) {
        try {
            Reserve result = reserveService.selectById(reserve);
            if (result == null)
                return new HttpResponse(0, null, "不存在");
            else
                return new HttpResponse(1, result, "查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpResponse(0, null, "请求错误");
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HttpResponse addReserve(@RequestBody Reserve reserve){
        int result = -1;
        try {
            result= reserveService.addReserveInfo(reserve);
            if (result == 0)
                return new HttpResponse(0,result,"添加失败");
            else
                return new HttpResponse(1,result,"添加成功");

        } catch (Exception e) {
            return new HttpResponse(0,result,"请求错误");
        }
    }
}
