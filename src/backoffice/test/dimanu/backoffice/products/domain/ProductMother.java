package dimanu.backoffice.products.domain;

import dimanu.backoffice.products.application.CreateProductCommand;

public class ProductMother {

    public static final String VALID_ID = "8e197c6-0379-4142-acb7-9234f460ca6e";

    public static Product withValidId() {
        return new Product(
                VALID_ID,
                "anyName",
                "anyDescription",
                100.0,
                10
        );
    }

    public static Product fromRequest(CreateProductCommand command) {
        return new Product(
                command.id(),
                command.name(),
                command.description(),
                command.price(),
                command.stock()
        );
    }
}
