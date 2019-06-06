package hotmail.inspector;

import hotmail.mail.Letter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("inspector")
public interface InspectorService {

    @PostMapping("/letters/inspect")
    boolean isAllowedToDeliver(@RequestBody Letter letter);
}
