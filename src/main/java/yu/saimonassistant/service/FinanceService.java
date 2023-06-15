package yu.saimonassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.saimonassistant.dto.FinanceRangeRequest;
import yu.saimonassistant.dto.FinanceStatResponse;
import yu.saimonassistant.entity.Finance;
import yu.saimonassistant.mapper.FinanceMapper;
import yu.saimonassistant.util.UUIDUtil;

@Service
public class FinanceService {
	@Autowired
	private FinanceMapper mapper;

	public FinanceStatResponse queryStat(FinanceRangeRequest req){
		var durationList = mapper.selectByDuration(
			req.getStartTime(), req.getEndTime());

		var resp = new FinanceStatResponse();
		resp.setCount(durationList.size());
		resp.setTotalIn(durationList.stream()
				.filter(finance -> finance.getAmount() > 0.0)
				.mapToDouble(Finance::getAmount).sum()
			);
		resp.setTotalOut(durationList.stream()
			.filter(finance -> finance.getAmount() < 0.0)
			.mapToDouble(Finance::getAmount).sum()
		);

		return resp;
	}

	public int deleteById(Finance finance) {
		return mapper.deleteByPrimaryKey(finance.getId());
	}
}
