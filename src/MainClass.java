import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("John", 28),
                new User("Jane", 35),
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





    }

    private static void printUsers(String message, List<User> users){
        if (!message.equals("")){
            System.out.print(message);
        }
        for (User user: users){
            System.out.println(user);
        }
    }


}
