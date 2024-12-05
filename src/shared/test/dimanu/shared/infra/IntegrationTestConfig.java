package dimanu.shared.infra;

import dimanu.app.Starter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Starter.class)
@SpringBootTest
public class IntegrationTestConfig {
}
