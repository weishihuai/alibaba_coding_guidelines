package com.wsh.coding.guidelines.programmingcode;

/**
 * @Title: Person
 * @ProjectName alibaba_coding_guidelines
 * @Description:
 * @Author WeiShiHuai
 * @Date 2018/10/8 16:07
 */
public class Person {

    private String personName;
    private int age;

    public static final String name = "weixiaohuai";

    public static void printName() {
    }

    public static void printNames(int id, String... names) {
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", age=" + age +
                '}';
    }
}
