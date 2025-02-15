package Users;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

//        User user1 = new User("Hien1", 162, 26, "female");
//        User user2 = new User("Hien2", 162, 26, "female");
//        User user3 = new User("Hien3", 162, 26, "female");
//        List<User> userList = Arrays.asList(user1, user2, user3);
        System.out.println("Danh sach user:");
        User[] users = new User[7];
        users[0] = new User();
        users[1] = new User();
        users[2] = new User();
        users[3] = new User();
        users[4] = new User();
        users[5] = new User();
        users[6] = new User();
        //------------------------------------
        System.out.println("==================================================\n");

        //List user:
        System.out.println("User theo list:");
        List<User> userList= Arrays.asList(new User(),new User(),new User(),new User(),new User(),new User(),new User());
        for (User user : users) {
            user.info();
            userList.stream().max(Comparator.comparing(User::getYearOld)).get().info();
        }
        System.out.println("==================================================\n");
        //==========================
        for (User user : users) {
            System.out.printf("Danh sach: Name %s, %d tuoi, %d cm, %s\n", user.getName(), user.getYearOld(), user.getHeight(), user.getGender());
//            user.info(); //dong nay thay cho dong tren khi da co ham public void info ben class User
        }
        System.out.println("==================================================\n");
        //Tim user lon tuoi  nhat
        System.out.println("User lon tuoi nhat la:");
        User maxOlduser = Arrays.stream(users).max(Comparator.comparing(User::getYearOld)).get(); //Array
        System.out.println("==================================================\n");

        userList.stream().max(Comparator.comparing(User::getYearOld)).get().info(); //List
        System.out.printf("Name: %s, %d tuoi, %d cm, Gender: %s\n", maxOlduser.getName(), maxOlduser.getYearOld(), maxOlduser.getHeight(), maxOlduser.getGender());
        System.out.println("==================================================\n");

        //Tim user lon nho tuoi nhat
        System.out.println("User nho tuoi nhat la:");
        User minOlduser = Arrays.stream(users).min(Comparator.comparing(User::getYearOld)).get();
        System.out.printf("Name: %s, %d tuoi, %d cm, Gender: %s\n", minOlduser.getName(), minOlduser.getYearOld(), minOlduser.getHeight(), minOlduser.getGender());

        //Cach 2: dung info();
//        for (User user : users) {
//        user.info(); //dong nay thay cho dong tren khi da co ham public void info ben class User
//            }
//        Arrays.stream(users).max(Comparator.comparing (User::getYearOld)).get().info();
//        Arrays.stream(users).min(Comparator.comparing (User::getYearOld)).get().info();
        System.out.println("==================================================\n");

        //Danh sach user la female
        System.out.println("User Female list");
        List<User> femaleUsers = Arrays.stream(users).filter (user -> user.getGender().equals("female")).toList();
        for (User user: femaleUsers) {
            user.info();
        }
        List<String> names = Arrays.stream(users).map(User::getName).toList();
        System.out.println(names);
        System.out.println("==================================================\n"); //Sum total year old

        int totalYearOlds = Arrays.stream(users).mapToInt(User::getYearOld).sum();
        System.out.printf("Tong so tuoi user la: %s \n",totalYearOlds);
        System.out.println("==================================================\n"); //Sort by year old

        List <User> sortedByYearOldUsers = Arrays.stream(users).sorted (Comparator.comparing (User::getYearOld)).toList();
        for (User user: sortedByYearOldUsers){
            user.info();
        }
    }
    }

