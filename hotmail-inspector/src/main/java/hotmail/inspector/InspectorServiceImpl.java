package hotmail.inspector;

import hotmail.mail.Letter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InspectorServiceImpl implements InspectorService {

    private final BadWords badWords;

    @Override
    public boolean isAllowedToDeliver(Letter letter) {
        boolean forbidden = containsBadWord(letter.getUsername()) || containsBadWord(letter.getText());
        log.info("Inspecting {}. Is forbidden = {}", letter, forbidden);
        return !forbidden;
    }

    @SneakyThrows
    private boolean containsBadWord(String s) {
        Thread.sleep(300);
        s = s.toLowerCase();
        return badWords.getBadWords().stream().anyMatch(s::contains);
    }
}
