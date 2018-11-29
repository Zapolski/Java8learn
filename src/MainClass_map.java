import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MainClass_map {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,100);
        map.put(2,200);
        map.put(3,300);
        map.put(4,400);

        //по старинке
        /*for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }*/

        //лямбда
        map.forEach((k,v) -> System.out.println("Key: "+k+" Value: "+v));


        //собственный метод и лямбда
        Function<String,Integer> toInteger = string -> parse(string);
        System.out.println(toInteger.apply("5"));

        //собственный метод со ссылкой на метод
        Function<String,Integer> toIntegerWithRef = MainClass_map::parse;
        System.out.println(toIntegerWithRef.apply("11"));

        //ссылки на методы цепочкой обращений
        Function<String,String> trim = String::trim;
        String str = trim
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" ABCDEFG ");

        System.out.println(str);



    }

    private static Integer parse(String str){
        return Integer.parseInt(str);
    }
}
