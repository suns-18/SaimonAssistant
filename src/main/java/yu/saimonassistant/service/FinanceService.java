package yu.saimonassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.saimonassistant.entity.Finance;
import yu.saimonassistant.mapper.FinanceMapper;

@Service
public class FinanceService {
	@Autowired
	private FinanceMapper mapper;

	public int deleteById(Finance finance) {
		return mapper.deleteByPrimaryKey(finance.getId());
	}
}
