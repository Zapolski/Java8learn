//предопределенный функциональный интерфейс
/*
public interface BinaryOperator<T> {
    T apply(T t1, T t2);
}*/

import java.util.function.BinaryOperator;

public class BinaryOperatorApp {
    public static void main(String[] args) {
        BinaryOperator<Integer> multiply = (x,y) -> x*y;
        System.out.println(multiply.apply(5,6));
    }
}
