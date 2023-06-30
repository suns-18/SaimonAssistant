package yu.seimonassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.seimonassistant.entity.Investment;
import yu.seimonassistant.mapper.InvestmentMapper;
import yu.seimonassistant.util.UUIDUtil;

import java.util.List;

@Service
public class InvestService {
    @Autowired
    private InvestmentMapper mapper;

    public int insert(Investment investment) {
        if (investment.getId() == null ||
                investment.getId().isEmpty())
            investment.setId(UUIDUtil.getOneUUID());
        return mapper.insert(investment);
    }

    public int deleteById(Investment investment) {
        return mapper.deleteById(investment.getId());
    }

    public int update(Investment investment) {
        return mapper.update(investment);
    }

    public Investment selectById(Investment investment) {
        return mapper.selectById(investment.getId());
    }

    public List<Investment> selectAll() {
        return mapper.selectAll();
    }
}
