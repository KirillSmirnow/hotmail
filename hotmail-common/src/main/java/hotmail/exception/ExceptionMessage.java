package hotmail.exception;

import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
public class ExceptionMessage {

    private static final String UNKNOWN_EXCEPTION_USER_MESSAGE = "An error has occurred";

    private final String userMessage;
    private final String developerMessage;

    @ConstructorProperties({"userMessage", "developerMessage"})
    public ExceptionMessage(String userMessage, String developerMessage) {
        this.userMessage = userMessage;
        this.developerMessage = developerMessage;
    }

    public static ExceptionMessage unknown() {
        return new ExceptionMessage(UNKNOWN_EXCEPTION_USER_MESSAGE, UNKNOWN_EXCEPTION_USER_MESSAGE);
    }

    public static ExceptionMessage unknown(Exception e) {
        return new ExceptionMessage(UNKNOWN_EXCEPTION_USER_MESSAGE, e.getMessage());
    }
}
