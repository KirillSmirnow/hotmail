package hotmail.mail;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("mail")
public interface MailService {

    @PostMapping("/letters")
    void send(@RequestBody Letter letter);

    @GetMapping("/letters")
    List<Letter> getRecentLetters();
}
