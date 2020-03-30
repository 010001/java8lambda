package com.github.fb010001.java8lambda.mylambda.demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 20-3-27 上午11:00
 */
public class Test01 {
    public static void main(String[] args) {
        Apple apple01 = new Apple("red",110);
        Apple apple011 = new Apple("red",111);
        Apple apple012 = new Apple("red",112);
        Apple apple02 = new Apple("yellow",120);
        Apple apple021 = new Apple("yellow",121);
        Apple apple022 = new Apple("yellow",122);
        Apple apple03 = new Apple("blue",130);
        Apple apple031 = new Apple("blue",131);
        Apple apple032 = new Apple("blue",132);
        List<Apple> apples = Arrays.asList(apple01,apple011,apple012,apple021,apple022,apple031,apple032,apple02,apple03);
        List<Apple> filterdApples = apples.stream().filter(apple -> {return "blue".equals(apple.getColour());}).collect(Collectors.toList());
        filterdApples.forEach(a->{
            System.out.println(a.getWeight());
        });
    }
}
