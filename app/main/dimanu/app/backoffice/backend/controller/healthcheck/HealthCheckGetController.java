package dimanu.app.backoffice.backend.controller.healthcheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/health-check")
public class HealthCheckGetController {

    @GetMapping
    public ResponseEntity<HashMap<String, String>> healthCheck() {
        HashMap<String, String> response = new HashMap<>();
        response.put(
                "status",
                "Healthy"
        );
        return ResponseEntity.status(HttpStatus.OK)
                             .body(response);
    }
}
