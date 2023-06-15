package yu.saimonassistant.dto;

import lombok.Data;

import java.util.Date;
@Data
public class FinanceRangeRequest {
	private Date startTime;
	private Date endTime;
}
