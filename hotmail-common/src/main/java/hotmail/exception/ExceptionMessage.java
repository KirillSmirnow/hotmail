package hotmail.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionMessage {

    private final String userMessage;
    private final String developerMessage;

    @ConstructorProperties({"userMessage", "developerMessage"})
    public ExceptionMessage(String userMessage, String developerMessage) {
        this.userMessage = userMessage;
        this.developerMessage = developerMessage;
    }
}
