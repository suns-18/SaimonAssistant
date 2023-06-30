package yu.seimonassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yu.seimonassistant.request.FinanceRangeRequest;
import yu.seimonassistant.response.FinanceStatResponse;
import yu.seimonassistant.response.HttpResponse;
import yu.seimonassistant.entity.Finance;
import yu.seimonassistant.service.FinanceService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/finance")
public class FinanceController {
	@Autowired
	private FinanceService service;

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public HttpResponse delete(@RequestBody Finance finance) {
		int result = -1;
		try {
			result = service.deleteById(finance);
			if (result == 0)
				return new HttpResponse(0, result, "删除失败");
			else
				return new HttpResponse(1, result, "删除成功");
		} catch (Exception e) {
			return new HttpResponse(0, result, "数据库访问出错");
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public HttpResponse modify(@RequestBody Finance finance) {
		int result = service.update(finance);
		try {
			if (result == 0)
				return new HttpResponse(0, result, "修改失败");
			else
				return new HttpResponse(1, result, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new HttpResponse(0, result, "数据库访问出错");
		}
	}

	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	public HttpResponse queryList() {
		try {
			List<Finance> result = service.selectAll();
			if (result.isEmpty())
				return new HttpResponse(1, result, "收支记录为空");
			else
				return new HttpResponse(1, result, "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new HttpResponse(0, null, "数据库访问出错");
		}
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public HttpResponse queryById(@RequestBody Finance finance) {
		try {
			Finance result = service.selectById(finance);
			if (result == null)
				return new HttpResponse(0, null, "不存在");
			else
				return new HttpResponse(1, result, "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new HttpResponse(0, null, "数据库访问出错");
		}
	}

	@RequestMapping(value = "/stat", method = RequestMethod.POST)
	public HttpResponse queryStat(@RequestBody FinanceRangeRequest req) {
		try {
			FinanceStatResponse result = service.queryStat(req);
			return new HttpResponse(1, result, "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new HttpResponse(0, null, "数据库访问出错");
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public HttpResponse add(@RequestBody Finance finance){
		int result = -1;
		try {
			result= service.insert(finance);
			if (result == 0)
				return new HttpResponse(0,result,"添加失败");
			else
				return new HttpResponse(1,result,"添加成功");

		} catch (Exception e) {
			return new HttpResponse(0,result,"数据库访问出错");
		}
	}
}
