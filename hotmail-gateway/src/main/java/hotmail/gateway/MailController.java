package hotmail.gateway;

import hotmail.mail.Letter;
import hotmail.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @Async
    @PostMapping("/letters")
    public void send(@RequestBody @Valid Letter letter) {
        mailService.send(letter);
    }

    @GetMapping("/letters")
    public List<Letter> getRecentLetters() {
        return mailService.getRecentLetters();
    }
}
