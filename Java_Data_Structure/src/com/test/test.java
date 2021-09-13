package com.test;

public class test {
    public static void main(String[] args) {
        pig pig = new pig();
        pig.value();

    }
}

class animal {
    public String name;
    void value() {
        name = "China";
    }
}
class pig extends animal{
    public String name;

    void value() {
        name = "Shanghai";
        super.value();      //调用父类的方法
        System.out.println(name);
        System.out.println(super.name);
    }
}
