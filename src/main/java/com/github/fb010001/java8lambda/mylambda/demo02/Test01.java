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

    public enum DishLevel {LOW,MIDDLE,HIGH}

    @Test
    public void test13(){
        //分组
        Dish dish01 = new Dish("肘子",510,false);
        Dish dish011 = new Dish("肘子1",530,false);
        Dish dish012 = new Dish("肘子2",550,false);
        Dish dish02 = new Dish("菜花",170,false);
        Dish dish03 = new Dish("韭菜",58,true);
        Dish dish04 = new Dish("鱼肉水饺",280,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        Map<Boolean, List<Dish>> collect = dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian));
        //System.out.println(collect);
        Map<DishLevel, List<Dish>> collect1 = dishs.stream().collect(Collectors.groupingBy(dish -> {
            if (dish.getHeat() < 200) {
                return DishLevel.LOW;
            } else if (dish.getHeat() < 500) {
                return DishLevel.MIDDLE;
            } else {
                return DishLevel.HIGH;
            }
        }));
        System.out.println(collect1);
    }

    /**
     * {
     * 	false={
     * 		MIDDLE=[
     * 			Dish(name=菜花, heat=170, isVegetarian=false)],
     * 		HIGH=[
     * 			Dish(name=肘子, heat=510, isVegetarian=false),
     * 			Dish(name=肘子1, heat=530, isVegetarian=false),
     * 			Dish(name=肘子2, heat=550, isVegetarian=false)],
     * 		NIRMAL=[
     * 			Dish(name=鱼肉水饺, heat=280, isVegetarian=false)]
     *        },
     * 	true={
     * 		MIDDLE=[
     * 			Dish(name=韭菜, heat=58, isVegetarian=true)]}
     * }
     */
    @Test
    public void test14(){
        //多级分组
        Dish dish01 = new Dish("肘子",510,false);
        Dish dish011 = new Dish("肘子1",530,false);
        Dish dish012 = new Dish("肘子2",550,false);
        Dish dish02 = new Dish("菜花",170,false);
        Dish dish03 = new Dish("韭菜",58,true);
        Dish dish04 = new Dish("鱼肉水饺",280,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        Map<Boolean, List<Dish>> collect = dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian));
        //System.out.println(collect);
        Map<Boolean, Map<DishLevel, List<Dish>>> collect1 = dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian, Collectors.groupingBy(dish -> {
            if (dish.getHeat() < 200) {
                return DishLevel.LOW;
            } else if (dish.getHeat() < 500) {
                return DishLevel.MIDDLE;
            } else {
                return DishLevel.HIGH;
            }
        })));
        System.out.println(collect1);
    }

    @Test
    public void test15(){
        //获取分组的每组的数量
        Dish dish01 = new Dish("肘子",510,false);
        Dish dish011 = new Dish("肘子1",530,false);
        Dish dish012 = new Dish("肘子2",550,false);
        Dish dish02 = new Dish("菜花",170,false);
        Dish dish03 = new Dish("韭菜",58,true);
        Dish dish04 = new Dish("鱼肉水饺",280,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        Map<Boolean, List<Dish>> collect = dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian));

        System.out.println(dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian, Collectors.counting())));
    }


    /**
     * {
     * 	false=Optional[Dish(name=肘子2, heat=550, isVegetarian=false)],
     * 	true=Optional[Dish(name=韭菜, heat=58, isVegetarian=true)]
     * }
     */
    @Test
    public void test16(){
        //分组并按照热量从大到小排序区最大值
        Dish dish01 = new Dish("肘子",510,false);
        Dish dish011 = new Dish("肘子1",530,false);
        Dish dish012 = new Dish("肘子2",550,false);
        Dish dish02 = new Dish("菜花",170,false);
        Dish dish03 = new Dish("韭菜",58,true);
        Dish dish04 = new Dish("鱼肉水饺",280,false);

        List<Dish> dishs = Arrays.asList(dish01,dish02,dish03,dish04,dish011,dish012);
        //Map<Boolean, List<Dish>> collect = dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian));

        //System.out.println(dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian,Collectors.maxBy(Comparator.comparingInt(Dish::getHeat)))));
        System.out.println("分组中热量最高的菜品");
        System.out.println(dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian,Collectors.maxBy(Comparator.comparing(Dish::getHeat)))));


        System.out.println(dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian,Collectors.counting())));

        //比较菜品热量
        //Comparator<Dish> dishHeatComparator = Comparator.comparingInt(Dish::getHeat);
        //System.out.println(dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian,Collectors.maxBy(dishHeatComparator))));


        dishs.stream().sorted(Comparator.comparing(Dish::getHeat)).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("===============");
        /**
         * {
         * 	false=[
         * 		Dish(name=菜花, heat=170, isVegetarian=false),
         * 		Dish(name=鱼肉水饺, heat=280, isVegetarian=false),
         * 		Dish(name=肘子, heat=510, isVegetarian=false),
         * 		Dish(name=肘子1, heat=530, isVegetarian=false),
         * 		Dish(name=肘子2, heat=550, isVegetarian=false)],
         * 	true=[
         * 		Dish(name=韭菜, heat=58, isVegetarian=true)]
         * }
         * 分组并排序
         */
        Map<Boolean, List<Dish>> collect = dishs.stream().sorted(Comparator.comparing(Dish::getHeat)).collect(Collectors.groupingBy(Dish::isVegetarian));
        System.out.println(collect);

        System.out.println("降序排序");
        List<Dish> collect1 = dishs.stream().sorted((d1, d2) -> d1.getHeat()>d2.getHeat()?-1:(d1.getHeat()==d2.getHeat()?0:1)).collect(Collectors.toList());
        System.out.println(collect1);
        System.out.println("降序分组");
        System.out.println(dishs.stream().sorted((d1, d2) -> d1.getHeat()>d2.getHeat()?-1:(d1.getHeat()==d2.getHeat()?0:1)).collect(Collectors.groupingBy(Dish::isVegetarian)));
        //System.out.println(collect);
        System.out.println("升序排序");
        List<Dish> collect2 = dishs.stream().sorted((d1, d2) -> d1.getHeat()<d2.getHeat()?-1:(d1.getHeat()==d2.getHeat()?0:1)).collect(Collectors.toList());
        System.out.println(collect2);
        System.out.println("升序分组");
        System.out.println(dishs.stream().sorted((d1, d2) -> d1.getHeat()<d2.getHeat()?-1:(d1.getHeat()==d2.getHeat()?0:1)).collect(Collectors.groupingBy(Dish::isVegetarian)));
    }

    @Test
    public void test17() {
        //分组并按照热量从大到小排序区最大值
        Dish dish01 = new Dish("肘子", 510, false);
        Dish dish011 = new Dish("肘子1", 530, false);
        Dish dish012 = new Dish("肘子2", 550, false);
        Dish dish02 = new Dish("菜花", 170, false);
        Dish dish03 = new Dish("韭菜", 58, true);
        Dish dish04 = new Dish("鱼肉水饺", 280, false);

        List<Dish> dishs = Arrays.asList(dish01, dish02, dish03, dish04, dish011, dish012);

        /**
         * 获取分组的菜品中有那些热量品级的菜品
         */
        Map<Boolean, Set<DishLevel>> collect = dishs.stream().collect(Collectors.groupingBy(Dish::isVegetarian, Collectors.mapping(d -> {
            if (d.getHeat() < 200) {
                return DishLevel.LOW;
            } else if (d.getHeat() < 500) {
                return DishLevel.MIDDLE;
            } else {
                return DishLevel.HIGH;
            }
        }, Collectors.toSet())));

        System.out.println(collect);
    }


    @Test
    public void test18() {
        //分区
        Dish dish01 = new Dish("肘子", 510, false);
        Dish dish011 = new Dish("肘子1", 530, false);
        Dish dish012 = new Dish("肘子2", 550, false);
        Dish dish02 = new Dish("菜花", 170, false);
        Dish dish03 = new Dish("韭菜", 58, true);
        Dish dish04 = new Dish("鱼肉水饺", 280, false);

        List<Dish> dishs = Arrays.asList(dish01, dish02, dish03, dish04, dish011, dish012);

        Map<Boolean, List<Dish>> collect = dishs.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        /**
         * {
         * 	false=[
         * 		Dish(name=肘子, heat=510, isVegetarian=false),
         * 		Dish(name=菜花, heat=170, isVegetarian=false),
         * 		Dish(name=鱼肉水饺, heat=280, isVegetarian=false),
         * 		Dish(name=肘子1, heat=530, isVegetarian=false),
         * 		Dish(name=肘子2, heat=550, isVegetarian=false)],
         * 	true=[
         * 		Dish(name=韭菜, heat=58, isVegetarian=true)]
         * }
         */
        System.out.println(collect);
        System.out.println(collect.get(true));
        System.out.println(collect.get(false));


        //dishs.stream().collect(Collectors.partitioningBy(Dish::isVegetarian,Collectors.maxBy(Dish::getHeat)),Optional::get);


        Map<Boolean, Optional<Dish>> collect1 = dishs.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.maxBy(Comparator.comparing(Dish::getHeat))));
        System.out.println();
        System.out.println(collect1);

        Map<Boolean, Optional<Dish>> collect222 = dishs.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.maxBy(Comparator.comparing(Dish::getHeat))));


        System.out.println("=============");
        Map<Boolean, Dish> collect3 = dishs.stream().collect(
                Collectors.partitioningBy(
                        Dish::isVegetarian,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getHeat)),
                                Optional::get
                        )
                )
        );
        System.out.println(collect3);
        System.out.println(collect3.get(true).getName());


        //dishs.stream().collect(Collectors.partitioningBy(Dish::isVegetarian,Collectors.collectingAndThen(Comparator.comparing(Dish::getHeat),Optional::get)));
    }

}
