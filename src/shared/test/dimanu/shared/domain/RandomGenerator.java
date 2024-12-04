package dimanu.shared.domain;

import com.github.javafaker.Faker;

import java.util.UUID;

public class RandomGenerator {
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String word() {
        return Faker.instance().lorem().word();
    }

    public static String sentence() {
        return Faker.instance().lorem().sentence();
    }

    public static double doubleBetween(int min, int max) {
        return Faker.instance().number().randomDouble(2, min, max);
    }

    public static int integerBetween(int min, int max) {
        return Faker.instance().number().numberBetween(min, max);
    }
}
