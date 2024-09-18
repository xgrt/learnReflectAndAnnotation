package com.xgrt.domain;

import lombok.Data;

@Data
public class Cat {
    private String name;
    private int age;

    private void sayHello() {
        System.out.println("喵喵喵！我是" + this.name + " 今年" + this.age + "岁");
    }

    private String sayHello(String nameToSay) {
        return nameToSay+"！我是" + this.name + " 今年" + this.age + "岁";
    }

    public void go() {
        System.out.println(this.name + "向前走");
    }

    public String toString() {
        return "我是" + this.name + "，" +
                "今年" + this.age + "岁";
    }

    public Cat (){
        this.age = 0;
        this.name = "cat";
    }

    public Cat(String name) {
        this.name = name;
    }
    public Cat(int age) {
        this.age = age;
    }
    private Cat(int age, String name) {
        this.name = name;
        this.age = age;
    }
}
