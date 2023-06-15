package yu.saimonassistant.entity;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@ToString
public class Finance extends Record{
	private double amount;
}
