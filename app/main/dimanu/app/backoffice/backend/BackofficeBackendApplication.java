package dimanu.app.backoffice.backend;

import dimanu.app.backoffice.backend.command.FakeCommand;
import dimanu.shared.domain.ApplicationRepository;
import dimanu.shared.domain.ApplicationService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {ApplicationRepository.class, ApplicationService.class}
        ),
        value = {"dimanu.shared", "dimanu.backoffice", "dimanu.app.backoffice"}
)
public class BackofficeBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
            put("fake", FakeCommand.class);
        }};
    }
}
