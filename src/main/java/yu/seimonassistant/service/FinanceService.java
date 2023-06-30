package yu.seimonassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.seimonassistant.request.FinanceRangeRequest;
import yu.seimonassistant.response.FinanceStatResponse;
import yu.seimonassistant.entity.Finance;
import yu.seimonassistant.mapper.FinanceMapper;
import yu.seimonassistant.util.UUIDUtil;

import java.util.List;

@Service
public class FinanceService {
    @Autowired
    private FinanceMapper mapper;

	public int insert(Finance finance) {
		if (finance.getId() == null
				|| finance.getId().isEmpty())
			finance.setId(UUIDUtil.getOneUUID());
		return mapper.insert(finance);
	}

    public int deleteById(Finance finance) {
        return mapper.deleteById(finance.getId());
    }

    public int update(Finance finance) {
        return mapper.update(finance);
    }

    public List<Finance> selectAll() {
        return mapper.selectAll();
    }

    public Finance selectById(Finance finance) {
        return mapper.selectById(finance.getId());
    }

	public FinanceStatResponse queryStat(FinanceRangeRequest req) {
		var durationList = mapper.selectBetweenDuration(
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
}
