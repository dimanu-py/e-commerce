package dimanu.app.backoffice.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsPutController {

    private final ProductCreator productCreator;

    public ProductsPutController(ProductCreator creator) {
        this.productCreator = creator;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> create(@PathVariable String id, Request request) {
        productCreator.create(id, request.name(), request.description(), request.price(), request.stock());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
