package hotmail.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Mail {

    public static void main(String[] args) {
        SpringApplication.run(Mail.class);
    }
}
