package com.kanq.server.sso.service.nowcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/10/9:32
 * @Description: NC41 最长无重复子数组
 */
public class NC41 {

    public static void main(String[] args) {
        int [] array={1,1,2,2,5};
        int maxLength = getMaxLength(array);
        System.out.println(maxLength);
    }

    public static int getMaxLength(int[] arr){
        int maxLength=0;
        int left=0;
        int right=0;
        Map<Integer,Integer> map=new HashMap<>();
        if (arr==null||arr.length==0){
            return maxLength;
        }
        while (right<arr.length){
            map.put(arr[right], map.getOrDefault(arr[right],0)+1);
            int numInMap= arr[right];
            right++;
            while (map.get(numInMap)>1){
                int numOutMap=arr[left];
                left++;
                map.put(numOutMap,map.getOrDefault(numOutMap,0)-1);
            }

            maxLength=Math.max(maxLength,right-left);
        }
        return maxLength;
    }
}
