package yu.seimonassistant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Volunteer extends Record{
	private double assignment;
}
