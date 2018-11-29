import java.util.function.Predicate;

public class PredicateApp {

    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x>0;
        System.out.println(isPositive.test(5));
        System.out.println(isPositive.test(-5));
    }
}

/*
//предопределенный функциональный интерфейс
public interface Predicate<T> {
    boolean test(T t);
}
*/
