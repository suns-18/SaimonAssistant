package yu.saimonassistant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Volunteer extends Record{
	private double assignment;
}
