package hotmail.gateway;

import hotmail.mail.Letter;
import hotmail.mail.MailService;
import hotmail.mail.SendStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/letters")
    public SendStatus send(@RequestBody Letter letter) {
        return mailService.send(letter);
    }
}
