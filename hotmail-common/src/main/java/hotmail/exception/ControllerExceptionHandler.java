package hotmail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ControllerExceptionHandler {

    @ExceptionHandler(HotmailException.class)
    public ExceptionMessage handleMainException(HotmailException e) {
        return e.getExceptionMessage();
    }

    @ExceptionHandler(Exception.class)
    public ExceptionMessage handleOtherException(Exception e) {
        return ExceptionMessage.unknown(e);
    }
}
