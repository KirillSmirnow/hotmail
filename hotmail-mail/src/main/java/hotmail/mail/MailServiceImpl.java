package hotmail.mail;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import hotmail.inspector.InspectorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final InspectorService inspectorService;
    private final LetterRepository letterRepository;

    @HystrixCommand
    @Override
    public void send(Letter letter) {
        boolean allowedToDeliver = inspectorService.isAllowedToDeliver(letter);
        if (allowedToDeliver) {
            letterRepository.save(LetterEntity.of(letter));
            log.info("Letter delivered: {}", letter);
        } else {
            log.warn("Letter not allowed to deliver: {}", letter);
        }
    }

    @Override
    public List<Letter> getRecentLetters() {
        Sort sort = Sort.by("dateTime").descending();
        return letterRepository.findAll(PageRequest.of(0, 100, sort))
                .map(LetterEntity::toLetter)
                .getContent();
    }
}
