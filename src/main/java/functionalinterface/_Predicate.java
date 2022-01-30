package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("+9770987654321"));
        System.out.println(isPhoneNumberValid("+9770987"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("+9770987654321"));
        System.out.println(isPhoneNumberValidPredicate.test("+9770987"));

        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("+9770987"));
        System.out.println(isPhoneNumberValidPredicate.or(containsNumber3).test("+9770987654321"));

        System.out.println("Is valid user: "+isValidUser.test("harxsh", 25));
    }

    static BiPredicate<String, Integer> isValidUser = (username, age) -> username.length() > 5 && age >= 18;

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("+977") && phoneNumber.length() == 14;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+977") && phoneNumber.length() == 14;
    }
}
