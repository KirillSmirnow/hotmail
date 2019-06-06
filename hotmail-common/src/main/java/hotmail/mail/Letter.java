package hotmail.mail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

import static java.util.Arrays.asList;

@Data
public class Letter {

    @NotBlank
    private final String from;

    @NotBlank
    @Pattern(regexp = ".+@.+")
    private final String to;

    @NotBlank
    private final String text;

    @JsonIgnore
    public List<String> getFieldsToCheck() {
        return asList(from, to, text);
    }
}
