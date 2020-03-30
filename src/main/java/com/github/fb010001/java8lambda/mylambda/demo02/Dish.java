package com.github.fb010001.java8lambda.mylambda.demo02;

import lombok.Data;

/***
 *@Title 菜单
 *＠author    fangbin
 *@Date 20-3-27 上午11:23
 */
@Data
public class Dish {
    //菜品名称
    private String name;
    //热量
    private int heat;
    //是否适合素食
    private boolean isVegetarian;


    public Dish(String name, int heat, boolean isVegetarian) {
        this.name = name;
        this.heat = heat;
        this.isVegetarian = isVegetarian;
    }
}
