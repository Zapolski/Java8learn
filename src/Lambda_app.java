
//лямбды как параметры методов
//лямбды как результаты методов
public class Lambda_app {

    public static void main(String[] args) {

        Expression exc = n -> n%2==0;
        int[] num = {1,2,3,4,5,6,7,8,9};
        System.out.println(sum(num,exc));

        //без определения переменной интерфейса
        System.out.println(sum(num, (n)->n%2==0));

        int[] numbers = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        System.out.println(sum(numbers,ExpressionHelper::isEven));
        System.out.println(sum(numbers,ExpressionHelper::isPositive));

        UserBuilder ub = User2::new;
        User2 user2 = ub.create("Tom");
        System.out.println(user2);


        OperationReturn func = action(1);
        System.out.println(func.execute(6,5));

        func = action(2);
        System.out.println(func.execute(8,2));

    }

    private static int sum(int[] numbers, Expression func){
        int result = 0;
        for (int i : numbers){
            if (func.isEqual(i)){
                result += i;
            }
        }
        return result;
    }

    private static OperationReturn action (int number){
        switch (number){
            case 1: return (x,y)->x+y;
            case 2: return ((x, y) -> x-y);
            case 3: return (x,y)-> x*y;
            default:return (x,y)->0;
        }
    }
}

//функциональный интерфейс
interface Expression{
    boolean isEqual(int n);
}

//класс, в котором определены методы
class ExpressionHelper{
    static boolean isEven(int n){
        return n%2==0;
    }
    static boolean isPositive(int n){
        return n>0;
    }
}

class User2{
    private String name;

    public User2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface UserBuilder{
    User2 create(String name);
}

interface OperationReturn{
    int execute(int x,int y);
}


