package com.github.fb010001.java8lambda.mylambda.demo02;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/***
 *@Title 菜单
 *＠author    fangbin
 *@Date 20-3-27 上午11:23
 */
@Data
@Setter
@Getter
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }
}
