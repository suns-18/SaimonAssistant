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
	public int insert(Finance finance){
		// 插入前生成ID
		finance.setId(UUIDUtil.getOneUUID());
		return mapper.insert(finance);
	}
}
