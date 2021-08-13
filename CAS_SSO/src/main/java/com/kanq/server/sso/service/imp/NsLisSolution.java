package com.kanq.server.sso.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/04/11:19
 * @Description:
 */
public class NsLisSolution {

    public static void main(String[] args) {
        String n="110328328";
        Integer solution = Solution(n);
        System.out.println(solution);
    }

    public static Integer Solution(String n){
        Integer na= Integer.valueOf(n);
        Integer  [] aa=new Integer[na];
        for (int i = 0; i < aa.length; i++) {
            aa[i]=i+1;
        }
        Integer[] integerArray = getIntegerArray(aa);
        Integer maxDiff = getMaxDiff(integerArray);
        return  maxDiff;
    }

    public static Integer [] getIntegerArray(Integer[] sourceArray){
        Integer [] target=new Integer[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++) {
            Map<String, Integer> modAndRemainder = getModAndRemainder(sourceArray[i]);
            Integer sum=modAndRemainder.get("mod");
            while (modAndRemainder.get("remainder")!=0){
                Map<String, Integer> remainder = getModAndRemainder(modAndRemainder.get("remainder"));
                modAndRemainder.put("remainder",remainder.get("remainder"));
                sum+=remainder.get("mod");
            }
            target[i]=sum;
        }
        return  target;
    }


    public static Map<String,Integer> getModAndRemainder(Integer number){
        Map<String,Integer>map=new HashMap<>(3);
        Integer mod=number%10;
        Integer remainder=number/10;
        map.put("mod",mod);
        map.put("remainder",remainder);
        return map;
    }

    public static Integer getMaxDiff(Integer[] integers){

        List<Integer> numberList=new ArrayList<>();
        numberList.add(0);
        for (int i = 0; i < integers.length-1; i++) {
            if (integers[i]+1!=integers[i+1]){
                numberList.add(i+1);
            }
        }
        if (numberList.size()==1){
           numberList.add(integers.length);
        }
        Integer[] numberArray = numberList.toArray(new Integer[numberList.size()]);
        Integer length=0;
        for (int i = 0; i < numberArray.length-1; i++) {
            if (numberArray[i+1]-numberArray[i]>=length){
                length=numberArray[i+1]-numberArray[i];
            }
        }
        return  length;
    }


    public static Integer [] getIntegerArrayNew(Integer[] sourceArray){
        Integer [] target=new Integer[sourceArray.length];
        for (int i = 0; i < sourceArray.length; i++) {
            int remainder = sourceArray[i] / 10;
            int mod = sourceArray[i] % 10;
            Integer sum=mod;
            while (remainder!=0){
                mod=remainder%10;
                remainder=remainder/10;
                sum=sum+mod;
            }
            target[i]=sum;
        }
        return target;
    }


}
