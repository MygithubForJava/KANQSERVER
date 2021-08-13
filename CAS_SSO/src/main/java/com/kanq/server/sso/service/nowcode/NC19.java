package com.kanq.server.sso.service.nowcode;

import javax.validation.constraints.Max;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/11/13:42
 * @Description: 动态规划求子数组最大累加和
 */
public class NC19 {

    public static void main(String[] args) {

    }

    public static int getMaxSubArraySum(int [] array){
        if (array.length==1){return array[0];}
        int [] d=new int[array.length];
        d[0]=array[0];
        int res=array[0];
        for (int i = 1; i < array.length; i++) {
            d[i]= Math.max(0,d[i-1])+array[i];
            res=Math.max(d[i],res);
        }
        return res;
    }
}
