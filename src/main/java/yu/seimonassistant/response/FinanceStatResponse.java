package yu.seimonassistant.response;

import lombok.Data;

@Data
public class FinanceStatResponse {
	private int count;
	private double totalIn;
	private double totalOut;
}
