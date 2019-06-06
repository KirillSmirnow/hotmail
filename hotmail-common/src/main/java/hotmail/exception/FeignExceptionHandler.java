package hotmail.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class FeignExceptionHandler implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String method, Response response) {
        try {
            InputStream messageStream = response.body().asInputStream();
            ExceptionMessage exceptionMessage = objectMapper.readValue(messageStream, ExceptionMessage.class);
            return new HotmailException(exceptionMessage);
        } catch (Exception e) {
            return new HotmailException(ExceptionMessage.unknown());
        }
    }
}
