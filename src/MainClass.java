import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        UserFactory userFactory = User::new;






        List<User> users = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
                new User("Anna", 35),
                userFactory.create("Andy",44),
                new User("Alex", 21));

        printUsers("Before sort:\n",users);

        //сортировка через Comparator
        /*Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.age-o2.age;
            }
        });*/

        //сортировка через Collections
        /*Collections.sort(users,(o1, o2) -> o1.getAge()-o2.getAge());*/

        //сортировка через List
        users.sort(((o1, o2) -> o1.getAge()-o2.getAge()));
        printUsers("After sort by AGE:\n", users);

        //сортировка в обратном направлении (компаратор остается неизменным)
        Comparator<User> comparator = (o1,o2)->o1.getAge()-o2.getAge();
        users.sort(comparator.reversed());
        printUsers("After sort by AGE (reversed):\n", users);

        //сортировка по имени
        comparator = (o1,o2)->o1.getName().compareTo(o2.getName());
        users.sort(comparator);
        printUsers("After sort by NAME:\n", users);

        //сортировка с несколькими условиями
        users.sort((o1, o2) -> {
            if (o1.getAge()==o2.getAge()){
                return o1.getName().compareTo(o2.getName());
            }else{
                return o1.getAge()-o2.getAge();
            }
        });
        printUsers("After sort with a few conditions:\n", users);


        //сортировка со ссылками на методы
        System.out.println();
        users.sort(Comparator.comparing(User::getName));
        users.forEach(System.out::println);

    }

    private static void printUsers(String message, List<User> users){
        if (message!=null){
            if (!message.equals("")){
                System.out.print(message);
            }
        }
        //лямбда для форыча
        //users.forEach(user -> System.out.println(user));

        //foreach с условием
        /*users.forEach(user -> {
            if (user.getAge()<30) System.out.println(user);
        });*/

        //лямбда со ссылкой на метод
        users.forEach(System.out::println);

        /*for (User user: users){
            System.out.println(user);
        }*/
    }


}
