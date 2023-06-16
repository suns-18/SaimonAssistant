package yu.seimonassistant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Reserve extends Record{
	private Date startTime;
	private Date endTime;
}
