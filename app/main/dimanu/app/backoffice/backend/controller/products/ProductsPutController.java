package dimanu.app.backoffice.backend.controller.products;

import dimanu.backoffice.products.application.CreateProductCommand;
import dimanu.backoffice.products.application.ProductCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsPutController {

    private final ProductCreator productCreator;

    public ProductsPutController(ProductCreator creator) {
        this.productCreator = creator;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> create(@PathVariable String id, @RequestBody Request request) {
        CreateProductCommand command = new CreateProductCommand(
                id,
                request.name(),
                request.description(),
                request.price(),
                request.stock()
        );
        productCreator.create(command);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .build();
    }
}
