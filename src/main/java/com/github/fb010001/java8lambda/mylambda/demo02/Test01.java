package com.github.fb010001.java8lambda.mylambda.demo02;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 20-3-27 上午11:18
 */
public class Test01 {

    @Test
    public void test01(){
        //distinct筛选
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream().filter(i -> i%2 == 0).distinct().forEach(System.out::println);
    }

    @Test
    public void test02(){
        Dish dish01 = new Dish("肘子",500,false);
        Dish dish02 = new Dish("菜花",100,false);
        Dish dish03 = new Dish("韭菜",50,true);
        Dish dish04 = new Dish("鱼肉水饺",200,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04);
        dishs.stream().filter(i -> i.getHeat()> 100).distinct().forEach(System.out::println);
    }

    @Test
    public void test03(){
        Dish dish01 = new Dish("肘子",500,false);
        Dish dish02 = new Dish("菜花",100,false);
        Dish dish03 = new Dish("韭菜",50,true);
        Dish dish04 = new Dish("鱼肉水饺",200,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04);
        dishs.stream().filter(Dish::isVegetarian).distinct().forEach(System.out::println);
    }

    @Test
    public void test04(){
        //截短流
        Dish dish01 = new Dish("肘子",500,false);
        Dish dish011 = new Dish("肘子1",500,false);
        Dish dish012 = new Dish("肘子2",500,false);
        Dish dish02 = new Dish("菜花",100,false);
        Dish dish03 = new Dish("韭菜",50,true);
        Dish dish04 = new Dish("鱼肉水饺",200,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        dishs.stream().filter(i ->  {return i.getHeat() > 100;}).distinct().forEach(System.out::println);
        System.out.println("=======");
        dishs.stream().filter(i ->  i.getHeat() > 100).limit(2).distinct().forEach(System.out::println);
    }

    @Test
    public void test0５(){
        //跳过元素
        Dish dish01 = new Dish("肘子",500,false);
        Dish dish011 = new Dish("肘子1",500,false);
        Dish dish012 = new Dish("肘子2",500,false);
        Dish dish02 = new Dish("菜花",100,false);
        Dish dish03 = new Dish("韭菜",50,true);
        Dish dish04 = new Dish("鱼肉水饺",200,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        dishs.stream().filter(i ->  {return i.getHeat() > 100;}).distinct().forEach(System.out::println);
        System.out.println("=======================");
        dishs.stream().filter(i ->  {return i.getHeat() > 100;}).distinct().skip(2).forEach(System.out::println);
    }

    @Test
    public void test06(){
        //限制元素
        Dish dish01 = new Dish("肘子",500,false);
        Dish dish011 = new Dish("肘子1",500,false);
        Dish dish012 = new Dish("肘子2",500,false);
        Dish dish02 = new Dish("菜花",100,false);
        Dish dish03 = new Dish("韭菜",50,true);
        Dish dish04 = new Dish("鱼肉水饺",200,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        dishs.stream().filter(i ->  {return i.getHeat() > 100;}).distinct().forEach(System.out::println);
        System.out.println("=======================");
        dishs.stream().filter(i ->  {return i.getHeat() > 100;}).distinct().limit(2).forEach(System.out::println);
    }

    @Test
    public void test07(){
        //映射元素
        Dish dish01 = new Dish("肘子",500,false);
        Dish dish011 = new Dish("肘子1",500,false);
        Dish dish012 = new Dish("肘子2",500,false);
        Dish dish02 = new Dish("菜花",100,false);
        Dish dish03 = new Dish("韭菜",50,true);
        Dish dish04 = new Dish("鱼肉水饺",200,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        List<String> dishNames = dishs.stream().map(Dish::getName).collect(Collectors.toList());
        dishNames.forEach(System.out::println);
    }

    @Test
    public void test08(){
        //映射元素
        Dish dish01 = new Dish("肘子",500,false);
        Dish dish011 = new Dish("肘子1",500,false);
        Dish dish012 = new Dish("肘子2",500,false);
        Dish dish02 = new Dish("菜花",100,false);
        Dish dish03 = new Dish("韭菜",50,true);
        Dish dish04 = new Dish("鱼肉水饺",200,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        List<Integer> dishNames = dishs.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        dishNames.forEach(System.out::println);
    }

    @Test
    public void test09(){
        //流的扁平化
        List<String> strs = Arrays.asList("hello","word");
        List<String> dishNames = strs.stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        dishNames.forEach(System.out::println);
    }

    @Test
    public void test10(){
        //归约
        List<String> strs = Arrays.asList("hello","word");
        System.out.println(strs.stream().count());
        //汇总
        System.out.println(strs.stream().collect(Collectors.counting()));
        //连接字符串
        System.out.println(strs.stream().collect(Collectors.joining(" ")));
    }

    @Test
    public void test11(){
        //获取最大值
        Dish dish01 = new Dish("肘子",510,false);
        Dish dish011 = new Dish("肘子1",530,false);
        Dish dish012 = new Dish("肘子2",550,false);
        Dish dish02 = new Dish("菜花",170,false);
        Dish dish03 = new Dish("韭菜",58,true);
        Dish dish04 = new Dish("鱼肉水饺",280,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        //比较菜品热量
        Comparator<Dish> dishHeatComparator = Comparator.comparingInt(Dish::getHeat);
        //获取热量最多的菜品
        Optional<Dish> mostHeatDish = dishs.stream().collect(Collectors.maxBy(dishHeatComparator));
        System.out.println(mostHeatDish.get().getName());

        Optional<Dish> mostHD = dishs.stream().collect(Collectors.reducing((d1,d2) -> {return d1.getHeat() > d2.getHeat()? d1:d2;}));
        System.out.println("mostHD -------> " + mostHD.get().getName());

        Optional<Dish> mostHD1 = dishs.stream().collect(Collectors.reducing((d1,d2) -> d1.getHeat() > d2.getHeat()? d1:d2 ));
        System.out.println("mostHD1 -------> " + mostHD1.get().getName());

        //汇总所有菜品的热量
        System.out.println(dishs.stream().collect(Collectors.summarizingDouble(Dish::getHeat)));
        System.out.println(dishs.stream().collect(Collectors.summarizingInt(Dish::getHeat)));
        //平均值
        System.out.println(dishs.stream().collect(Collectors.averagingInt(Dish::getHeat)));
    }

    @Test
    public void test12(){
        //distinct筛选
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        System.out.println(numbers.stream().collect(Collectors.counting()));


        Dish dish01 = new Dish("肘子",510,false);
        Dish dish011 = new Dish("肘子1",530,false);
        Dish dish012 = new Dish("肘子2",550,false);
        Dish dish02 = new Dish("菜花",170,false);
        Dish dish03 = new Dish("韭菜",58,true);
        Dish dish04 = new Dish("鱼肉水饺",280,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);

        System.out.println(dishs.stream().collect(Collectors.reducing(0,Dish::getHeat,Integer::sum)));

        Optional<Integer> dishHeatNums = dishs.stream().map(Dish::getHeat).reduce(Integer::sum);
        System.out.println("isPresent --> " + dishHeatNums.isPresent());
        System.out.println(dishs.stream().map(Dish::getHeat).reduce(Integer::sum).get());


    }

    @Test
    public void test13(){
        //分组
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        System.out.println(numbers.stream().collect(Collectors.counting()));


        Dish dish01 = new Dish("肘子",510,false);
        Dish dish011 = new Dish("肘子1",530,false);
        Dish dish012 = new Dish("肘子2",550,false);
        Dish dish02 = new Dish("菜花",170,false);
        Dish dish03 = new Dish("韭菜",58,true);
        Dish dish04 = new Dish("鱼肉水饺",280,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        Map<Boolean, List<Dish>> collect = dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian));
        System.out.println(collect);
    }

}
