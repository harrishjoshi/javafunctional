package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl() {
            return "127.0.0.1:3306/users";
    }

    static Supplier<List<String>> getDBConnectionUrlSupplier = () -> List.of("127.0.0.1:3306/users", "url2");
}
