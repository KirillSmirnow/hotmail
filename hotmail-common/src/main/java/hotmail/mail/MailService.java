package hotmail.mail;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("mail")
public interface MailService {

    @PostMapping("/letters")
    void send(@RequestBody Letter letter);
}
