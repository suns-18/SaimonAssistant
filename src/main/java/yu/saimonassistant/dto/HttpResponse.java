package yu.saimonassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpResponse {
	private int code;
	private Object data;
	private String msg;
}
