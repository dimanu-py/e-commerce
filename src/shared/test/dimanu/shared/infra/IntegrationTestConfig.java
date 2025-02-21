package dimanu.shared.infra;

import dimanu.app.backoffice.backend.BackofficeBackendApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = BackofficeBackendApplication.class)
@SpringBootTest
public class IntegrationTestConfig {
}
