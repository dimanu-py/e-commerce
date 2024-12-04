package dimanu.backoffice.products.domain;

import dimanu.backoffice.products.application.CreateProductCommand;

public class ProductMother {

    public static Product withValidId() {
        return new Product(
                ProductIdMother.create(),
                ProductNameMother.create(),
                ProductDescriptionMother.create(),
                ProductPriceMother.create(),
                ProductStockMother.create()
        );
    }

    public static Product fromRequest(CreateProductCommand command) {
        return Product.create(
                command.id(),
                command.name(),
                command.description(),
                command.price(),
                command.stock()
        );
    }
}
