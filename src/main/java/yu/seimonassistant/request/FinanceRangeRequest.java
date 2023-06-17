package yu.seimonassistant.request;

import lombok.Data;

import java.util.Date;
@Data
public class FinanceRangeRequest {
	private Date startTime;
	private Date endTime;
}
