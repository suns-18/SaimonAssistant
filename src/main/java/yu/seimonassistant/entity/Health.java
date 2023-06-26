package yu.seimonassistant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Health extends Record{
    private String id;
    private String title;
    private Date date;
    private String memo;
}
