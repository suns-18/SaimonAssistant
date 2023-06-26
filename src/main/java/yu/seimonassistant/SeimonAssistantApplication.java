package yu.seimonassistant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan
@SpringBootApplication
public class SeimonAssistantApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeimonAssistantApplication.class, args);
	}

}
