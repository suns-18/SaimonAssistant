package yu.seimonassistant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yu.seimonassistant.entity.Finance;
import yu.seimonassistant.entity.Volunteer;
import yu.seimonassistant.response.HttpResponse;
import yu.seimonassistant.service.VolunteerService;

import java.util.List;

@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {
    @Autowired
    private VolunteerService service;

    @PostMapping("/add")
    public HttpResponse add(@RequestBody Volunteer volunteer){
        int result = -1;
        try {
            result= service.insert(volunteer);
            if (result == 0)
                return new HttpResponse(0,result,"添加失败");
            else
                return new HttpResponse(1,result,"添加成功");

        } catch (Exception e) {
            return new HttpResponse(0,result,"数据库访问出错");
        }
    }

    @PostMapping("/del")
    public HttpResponse delete(@RequestBody Volunteer volunteer){
        int result = -1;
        try {
            result= service.update(volunteer);
            if (result == 0)
                return new HttpResponse(0,result,"添加失败");
            else
                return new HttpResponse(1,result,"添加成功");

        } catch (Exception e) {
            return new HttpResponse(0,result,"数据库访问出错");
        }
    }

    @PostMapping("/modify")
    public HttpResponse modify(@RequestBody Volunteer volunteer){
        int result = -1;
        try {
            result= service.update(volunteer);
            if (result == 0)
                return new HttpResponse(0,result,"添加失败");
            else
                return new HttpResponse(1,result,"添加成功");

        } catch (Exception e) {
            return new HttpResponse(0,result,"数据库访问出错");
        }
    }

    @PostMapping(value = "/queryList")
    public HttpResponse queryList() {
        try {
            var result = service.selectAll();
            if (result.isEmpty())
                return new HttpResponse(1, result, "志愿记录为空");
            else
                return new HttpResponse(1, result, "查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpResponse(0, null, "数据库访问出错");
        }
    }

    @PostMapping(value = "/query")
    public HttpResponse queryById(@RequestBody Volunteer volunteer) {
        try {
            var result = service.selectById(volunteer);
            if (result == null)
                return new HttpResponse(0, null, "不存在");
            else
                return new HttpResponse(1, result, "查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new HttpResponse(0, null, "数据库访问出错");
        }
    }
}
