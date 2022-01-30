package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElse("default value");
        System.out.println(value);

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");

        String hello = Optional.ofNullable("Hello")
                .orElseThrow(exception);
        System.out.println(hello);

        Optional.ofNullable("harxshjoshi@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));
    }
}
