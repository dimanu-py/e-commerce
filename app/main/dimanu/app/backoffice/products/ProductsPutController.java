package dimanu.app.backoffice.products;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsPutController {

    @PutMapping("/{id}")
    public void create(@PathVariable String id, Request request) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
