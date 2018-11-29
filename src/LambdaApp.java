public class LambdaApp {

    static int x = 10;
    static int y = 20;


    public static void main(String[] args) {
        //использование лямбда
        Operationable op1 = (x,y) -> x+y;
        System.out.println(op1.calculate(10,20));

        //при помощи внутренних анонимных классов
        Operationable op2 = new Operationable() {
            @Override
            public int calculate(int x, int y) {
                return x+y;
            }
        };
        System.out.println(op2.calculate(10,20));

        Operationable op3 = (x,y) -> x-y;
        System.out.println(op3.calculate(10,20));

        //Operationable op4 = () -> 20+30;

        //терминальные лямьбда выражения
        Printable printer = s -> System.out.println(s);
        printer.print("Hello world!");

        //использование переменных уровня класса
        Operation op5 = () ->{
            x=30;
            return x+y;
        };
        System.out.println(op5.calculate());

        int m = 30;
        int n = 70;
        Operation op6 = () ->{
            //m=10; - так нельзя делать
            return m+n;
        };
        //m=10; - так нельзя делать
        System.out.println(op6.calculate());

        OperationWithT<Integer> op7 = (x,y) -> x+y;
        OperationWithT<String> op8 = (x,y)  -> x+y;
        System.out.println(op7.calculate(10,20));
        System.out.println(op8.calculate("10","20"));
    }
}

//функциональный интерфейс
interface Operationable{
    int calculate (int x, int y);
}


interface Printable{
    void print(String s);
}

interface Operation{
    int calculate ();
}

//обобщенный функциональный интерфейс
interface OperationWithT<T>{
    T calculate (T x, T y);
}


