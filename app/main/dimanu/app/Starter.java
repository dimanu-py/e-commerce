package dimanu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"dimanu.app", "dimanu.backoffice"})
public class Starter {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }

}