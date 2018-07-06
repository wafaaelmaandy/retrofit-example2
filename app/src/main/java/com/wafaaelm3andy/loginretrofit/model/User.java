package com.wafaaelm3andy.loginretrofit.model;

public class User {
    String name ,Email;
    Integer id ;
    String [] topics  ;
    int age ;

    public User(String name, String email, String[] topics, int age) {
        this.name = name;
        Email = email;
        this.topics = topics;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
