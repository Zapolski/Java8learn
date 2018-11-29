//часть встроенных функциональные интерфейсы


/*
UnaryOperator<T> принимает в качестве параметра объект типа T, выполняет над ними операции и возвращает
результат операций в виде объекта типа T:
public interface UnaryOperator<T> {
    T apply(T t);
}

Функциональный интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R
public interface Function<T, R> {
    R apply(T t);
}

Consumer<T> выполняет некоторое действие над объектом типа T, при этом ничего не возвращая
public interface Consumer<T> {
    void accept(T t);
}

Supplier<T> не принимает никаких аргументов, но должен возвращать объект типа T:
public interface Supplier<T> {
    T get();
}

public interface BinaryOperator<T> {
    T apply(T t1, T t2);
}

public interface Predicate<T> {
    boolean test(T t);
}

*/


import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FuncInterface {
    public static void main(String[] args) {
        UnaryOperator<Integer> uo = (x) -> x*x;
        System.out.println(uo.apply(7));

        Function<Integer,String> func = num -> String.valueOf(num)+" dollars.";
        System.out.println(func.apply(7));

        Consumer<Integer> printer = x -> System.out.println(x+" dollars.");
        printer.accept(8);

        Supplier<User> userFactory = ()->{
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new User(name,0);
        };

        User user1 = userFactory.get();

        System.out.println(user1);

    }

}
