package hotmail.inspector;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Data
@Configuration
@ConfigurationProperties("hotmail")
public class BadWords {

    private Set<String> badWords;
}
