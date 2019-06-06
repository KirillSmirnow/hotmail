package hotmail.mail;

import lombok.Data;

@Data
public class SendStatus {

    private final boolean sent;
    private final String reason;
}
