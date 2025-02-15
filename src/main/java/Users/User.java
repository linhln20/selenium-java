package Users;

import java.util.Random;

public class User {
    /**
     * Exercise:
     * Create an Array of Users
     * Using the User domain object that you created previously.
     * Create an array containing 3 User objects
     */
    private String name;
    private int height;
    private int yearOld;
    private String gender;
//    public User(String name, int height, int yearOld, String gender) {
//        this.name = name;
//        this.height = height;
//        this.yearOld = yearOld;
//        this.gender = gender;

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getYearOld() {
        return yearOld;
    }

    public String getGender() {
        return gender;
    }

    //    viet cho a 1 ham random chieu cao tu 150-180
//    việt 1 ham ngẫu nhiên tu tu 25 45
public User() {
    this.name = randomName();
    this.height = randomNumber(150,180);
    this.yearOld = randomNumber(25,45);
    this.gender = randomGender();
}
private int randomNumber (int min, int max){
    Random rand= new Random();
    return rand.nextInt(max-min+1) +min;
}
//    random 1 name in array [Hien, Huong, Hung, Linh, Nga, Thao, Thy]
private String randomName(){
    Random rand = new Random();
    String[] name = {"Hien", "Huong", "Hung", "Linh", "Nga", "Thao", "Thy"};
    return name [rand.nextInt(name.length)];
}
// random gioi tinh
    private String randomGender(){
        Random rand =new Random();
        String[] name = {"Male", "Female"};
        return name [rand.nextInt(name.length)];
    }
    //cach 2: dung info();
public void info(){
    System.out.printf("Name %s, %d tuoi, %d cm, %s\n", this.getName(), this.getYearOld(), this.getHeight(), this.getGender());
}

}
