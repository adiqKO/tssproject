package pl.tss.Model;

import java.util.Objects;

public class User {

    private String user_name;
    private String password;

    public User(){}

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public User(User user) {
        this.user_name = user.user_name;
        this.password = user.password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_name.equals(user.user_name) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_name, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
