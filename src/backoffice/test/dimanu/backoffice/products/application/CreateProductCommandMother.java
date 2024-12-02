package dimanu.backoffice.products.application;

public class CreateProductCommandMother {

    public static final String VALID_ID = "8e197c6-0379-4142-acb7-9234f460ca6e";
    public static final String INVALID_ID = "12345";

    public static CreateProductCommand withValidId() {
        return new CreateProductCommand(
                VALID_ID,
                "anyName",
                "anyDescription",
                100.0,
                10
        );
    }

    public static CreateProductCommand withInvalidId() {
        return new CreateProductCommand(
                INVALID_ID,
                "anyName",
                "anyDescription",
                100.0,
                10
        );
    }
}
