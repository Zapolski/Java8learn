import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamApp {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"Paris","London","Madrid");
        list.stream()                           //получаем поток
                .filter(s -> s.length()==6)     //применяем фильтрацию по длине строки
                .forEach(System.out::println);  //выводим отфильтрованные строки на консоль

        Stream<String> cities = Arrays.stream(new String[]{"Paris","London","Madrid"});
        cities.forEach(System.out::println);

        IntStream intStream = Arrays.stream(new int[]{1,2,4,5,7});
        intStream.forEach(i->System.out.println(i));

        LongStream longStream = Arrays.stream(new long[]{100,250,400,5843787,237});
        longStream.forEach(l->System.out.println(l));

        DoubleStream doubleStream = Arrays.stream(new double[] {3.4, 6.7, 9.5, 8.2345, 121});
        doubleStream.forEach(d->System.out.println(d));

        Stream<String> citiesStream =Stream.of("Париж", "Лондон", "Мадрид");
        citiesStream.forEach(s->System.out.println(s));

        String[] cities2 = {"Париж", "Лондон", "Мадрид"};
        Stream<String> citiesStream2 =Stream.of(cities2);

        IntStream intStream2 = IntStream.of(1,2,4,5,7);
        intStream2.forEach(i->System.out.println(i));

        LongStream longStream2 = LongStream.of(100,250,400,5843787,237);
        longStream2.forEach(l->System.out.println(l));

        DoubleStream doubleStream2 = DoubleStream.of(3.4, 6.7, 9.5, 8.2345, 121);
        doubleStream2.forEach(d->System.out.println(d));


        Stream<String> citiesStream3 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
        citiesStream3.forEach(System.out::println);
    }
}
