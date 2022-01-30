package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", OTHERS),
                new Person("Aisha", FEMALE),
                new Person("Megan", FEMALE),
                new Person("Harish", MALE),
                new Person("Emma", FEMALE)
        );

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        /*people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);*/

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        boolean containsOnlyFemales = people.stream()
                .allMatch(personPredicate);
        System.out.println(containsOnlyFemales);

        boolean containsAnyFemales = people.stream()
                .anyMatch(personPredicate);
        System.out.println(containsAnyFemales);

        List<Person> males = people.stream()
                .filter(person -> person.gender.equals(MALE))
                .collect(Collectors.toList());

        boolean containsOnlyMales = males.stream()
                .allMatch(person -> person.gender.equals(MALE));
        System.out.println(containsOnlyMales);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, OTHERS
    }
}
