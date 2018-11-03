package design;

/**
 * Created by archithrapaka on 6/24/17.
 */

public class User {
    private String username;
    private int age;

    enum FriendType {
        CLOSE,
        AQUAINTANCE
    }

    private String profession;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

}
