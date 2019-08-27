package com.wzh.tools.demo.java.list;

import com.alibaba.fastjson.JSONObject;
import com.wzh.tools.demo.java.entity.People;
import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: list练习
 * @Author: wangzehui
 * @Date: 2019/6/14 14:07
 */

public class ListExercise {

    public static void main(String[] args) {
        List<People> peopleList = addList();

        listFilter(peopleList);

    }

    /**
     * list循环遍历
     */
    private static void listForEach(List<People> peopleList) {
        List<People> peopleListNew = new ArrayList<>();

        peopleList.forEach(people -> {
            People peopleNew = new People();
            peopleNew.setId(people.getId());
            peopleNew.setAge(people.getAge());
            peopleNew.setName(people.getName());
            peopleNew.setGroupId(people.getGroupId());
            peopleNew.setGroupName(people.getGroupName());
            peopleNew.setDescription(people.getDescription());
            peopleListNew.add(peopleNew);
        });

        System.out.println(JSONObject.toJSONString(peopleListNew));


    }


    /**
     * 统计list 按照某个属性
     */
    private static void statisticsList(List<People> peopleList) {
        IntSummaryStatistics stats = peopleList.stream().mapToInt(People::getAge).summaryStatistics();
        System.out.println("max : " + stats.getMax());
        System.out.println("min : " + stats.getMin());
        System.out.println("sum : " + stats.getSum());
        System.out.println("avg : " + stats.getAverage());
    }

    /**
     * list排序 按照某个属性
     */
    private static void listSort(List<People> peopleList) {
        //降序
        List<People> descList = peopleList.stream().sorted(Comparator.comparing(People::getAge).reversed()).collect(Collectors.toList());
        //升序
        List<People> ascList = peopleList.stream().sorted(Comparator.comparing(People::getAge)).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(descList));
    }


    /**
     * list排序 按照某个属性
     */
    private static void listSortNew(List<People> peopleList) {
        peopleList.sort(Comparator.comparing(People::getAge).reversed());
        System.out.println(JSONObject.toJSONString(peopleList));
    }

    /**
     * list分组 按照某个属性
     */
    private static void listGrouping(List<People> peopleList) {
        Map<Integer, List<People>> peopleMap = peopleList.stream().collect(Collectors.groupingBy(People::getGroupId));
        System.out.println(JSONObject.toJSONString(peopleMap));
    }


    /**
     * list对象 逗号拼接成字符串
     */
    private static void listToStrJoinSymbol(List<People> peopleList) {
        List<String> nameList = new ArrayList<>();
        for (People people : peopleList) {
            nameList.add(people.getName());
        }
        //方式1
        String nameStr1 = String.join(",", nameList);

        //方式2
        String nameStr2 = StringUtils.join(nameList, ",");

        System.out.println(JSONObject.toJSONString(nameStr1));
    }

    /**
     * list过滤 按照指定条件过滤
     */
    private static void listFilter(List<People> peopleList) {
        //过滤掉二组
        List<People> filterList = peopleList.stream().filter(people -> "一组".equals(people.getGroupName())).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(filterList));
    }


    private static List<People> addList() {
        List<People> peopleList = new ArrayList<>();
        People people1 = new People();
        people1.setId(1);
        people1.setAge(15);
        people1.setName("小明");
        people1.setGroupId(1);
        people1.setGroupName("一组");
        people1.setDescription("");
        People people2 = new People();
        people2.setId(2);
        people2.setAge(16);
        people2.setName("小红");
        people2.setGroupId(1);
        people2.setGroupName("一组");
        people2.setDescription("很高");
        People people3 = new People();
        people3.setId(3);
        people3.setAge(17);
        people3.setName("小李");
        people3.setGroupId(2);
        people3.setGroupName("二组");
        people3.setDescription("很胖");
        peopleList.add(people1);
        peopleList.add(people2);
        peopleList.add(people3);
        return peopleList;
    }

}
