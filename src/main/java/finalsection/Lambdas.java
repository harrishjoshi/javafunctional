package finalsection;

import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String, String> uppercaseName = String::toUpperCase;
        System.out.println(uppercaseName.apply("joe"));

        Function<String, String> uppercaseNameV2 = name -> {
            // logic here
            if (name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        System.out.println(uppercaseNameV2.apply("Harish"));
    }
}
