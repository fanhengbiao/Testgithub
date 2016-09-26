package com.example.mvp.personal;

/**
 * Created by fanhengbiao on 16-9-9.
 */

public class Personal {
    private String Name;
    private String age;

    public Personal(String name, String age) {
        Name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "Name='" + Name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
