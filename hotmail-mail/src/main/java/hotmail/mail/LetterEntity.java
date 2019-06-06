package hotmail.mail;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document("letters")
public class LetterEntity {

    private final UUID id;
    private final LocalDateTime dateTime;
    private final String from;
    private final String to;
    private final String text;

    public static LetterEntity of(Letter letter) {
        UUID id = UUID.randomUUID();
        LocalDateTime dateTime = LocalDateTime.now();
        return new LetterEntity(id, dateTime, letter.getFrom(), letter.getTo(), letter.getText());
    }

    public Letter toLetter() {
        return new Letter(from, to, text);
    }
}
