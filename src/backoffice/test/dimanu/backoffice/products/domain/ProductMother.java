package dimanu.backoffice.products.domain;

public class ProductMother {

    public static final String VALID_ID = "8e197c6-0379-4142-acb7-9234f460ca6e";

    public static Product with_valid_id() {
        return new Product(
                VALID_ID,
                "anyName",
                "anyDescription",
                100.0,
                10
        );
    }
}
