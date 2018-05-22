package com.tutorialspoint;

public class User {

    private int id;
    private String Name;

    public User(String vasya) {

        this.setName(vasya);
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }
}
