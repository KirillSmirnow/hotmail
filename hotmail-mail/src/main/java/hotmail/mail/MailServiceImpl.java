package hotmail.mail;

import hotmail.inspector.InspectorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final InspectorService inspectorService;

    @Override
    public SendStatus send(Letter letter) {
        boolean allowedToDeliver = inspectorService.isAllowedToDeliver(letter);
        if (allowedToDeliver) {
            log.info("Letter delivered: {}", letter);
        } else {
            log.warn("Letter not allowed to deliver: {}", letter);
        }
        return new SendStatus(allowedToDeliver, "Inspection " + (allowedToDeliver ? "passed" : "failed"));
    }
}
