package yu.saimonassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.saimonassistant.dto.FinanceRangeRequest;
import yu.saimonassistant.dto.FinanceStatResponse;
import yu.saimonassistant.entity.Finance;
import yu.saimonassistant.mapper.FinanceMapper;
import yu.saimonassistant.util.UUIDUtil;

import java.util.List;
import java.util.stream.Collectors;

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

	public int modifyFinanceInfo(Finance finance){ return mapper.updateByPrimaryKey(finance); }

	public List<Finance> queryFinanceList(){
		// 你这里获取的是列表，不是单个
		// 参数没有意义，别写
		return mapper.selectAll();
	}

	public Finance selectById(Finance finance){
		// 你这里获取的是单个，不是列表
		return mapper.selectByPrimaryKey(finance.getId());
	}
	public int addFinanceInfo(Finance finance){
		// 插入前生成ID
		finance.setId(UUIDUtil.getOneUUID());
		return mapper.insert(finance);
	}
}
