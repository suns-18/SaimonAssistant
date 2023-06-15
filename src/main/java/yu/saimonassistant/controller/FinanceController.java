package yu.saimonassistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yu.saimonassistant.dto.FinanceRangeRequest;
import yu.saimonassistant.dto.FinanceStatResponse;
import yu.saimonassistant.dto.HttpResponse;
import yu.saimonassistant.entity.Finance;
import yu.saimonassistant.service.FinanceService;

@RestController
@RequestMapping(value = "/api/finance")
public class FinanceController {
	@Autowired
	private FinanceService service;

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public HttpResponse deleteFinance(@RequestBody Finance finance) {
		int result = -1;
		try {
			result = service.deleteById(finance);
			if (result == 0)
				return new HttpResponse(0, result, "删除失败");
			else
				return new HttpResponse(1, result, "删除成功");
		} catch (Exception e) {
			return new HttpResponse(0, result, "请求错误");
		}
	}
}
