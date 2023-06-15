package yu.saimonassistant.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Record {
	private String id;
	private String title;
	private String memo;
	private Date date;
}
