package hotmail.exception;

import lombok.Getter;

@Getter
public class HotmailException extends RuntimeException {

    private final ExceptionMessage exceptionMessage;

    public HotmailException(String message) {
        this(message, message);
    }

    public HotmailException(String userMessage, String developerMessage) {
        super(userMessage);
        this.exceptionMessage = new ExceptionMessage(userMessage, developerMessage);
    }

    public HotmailException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getUserMessage());
        this.exceptionMessage = exceptionMessage;
    }
}
