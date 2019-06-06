package hotmail.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableCircuitBreaker
@SpringBootApplication
public class Gateway {

    public static void main(String[] args) {
        SpringApplication.run(Gateway.class);
    }
}
