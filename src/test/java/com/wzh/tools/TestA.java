package com.wzh.tools;

import com.alibaba.fastjson.JSONObject;
import com.wzh.tools.utils.list.SplitListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangzehui
 * @Date: 2020/4/24 10:54
 */

public class TestA {
    public static void main(String[] args) {
        A a1 = new A();
        a1.setComparedType(1);
        a1.setMatchValue(100);
        a1.setOperator("SystemQuestionsTask");
        a1.setResourceId(785739);
        a1.setSimilarId(785737);

        A a2 = new A();
        a2.setComparedType(1);
        a2.setMatchValue(100);
        a2.setOperator("SystemQuestionsTask");
        a2.setResourceId(785739);
        a2.setSimilarId(785740);

        A a3 = new A();
        a3.setComparedType(1);
        a3.setMatchValue(100);
        a3.setOperator("SystemQuestionsTask");
        a3.setResourceId(785740);
        a3.setSimilarId(785737);

        A a4 = new A();
        a4.setComparedType(1);
        a4.setMatchValue(100);
        a4.setOperator("SystemQuestionsTask");
        a4.setResourceId(785740);
        a4.setSimilarId(785739);

        A a5 = new A();
        a5.setComparedType(1);
        a5.setMatchValue(92);
        a5.setOperator("SystemQuestionsTask");
        a5.setResourceId(785741);
        a5.setSimilarId(248878);

        A a6 = new A();
        a6.setComparedType(1);
        a6.setMatchValue(100);
        a6.setOperator("SystemQuestionsTask");
        a6.setResourceId(785741);
        a6.setSimilarId(785732);

        List<A> aList = new ArrayList<>();
        aList.add(a1);
        aList.add(a2);
        aList.add(a3);
        aList.add(a4);
        aList.add(a5);
        aList.add(a6);

        for (int i = 0; i < aList.size(); i++) {
            for (int j = i + 1; j < aList.size(); j++) {
                if (aList.get(i).getSimilarId().equals(aList.get(j).getResourceId()) && aList.get(i).getResourceId().equals(aList.get(j).getSimilarId())) {
                    aList.remove(i);
                }
            }
        }
        List<List<A>> lists = SplitListUtils.averageAssign(aList, aList.size() / 1000);
        for (List<A> list : lists) {
            System.out.println(list.size());
            System.out.println(JSONObject.toJSONString(list));
        }

    }
}
