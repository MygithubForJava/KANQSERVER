package com.kanq.server.sso.service.nowcode;

import java.sql.Time;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/09/16:34
 * @Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class NC68 {

    public static void main(String[] args) {
        int i1 = jumFloor2(80000);
        System.out.println(i1);
        int i2 = jumpFloor3(80000);
        System.out.println(i2);
    }

    /**
     * f(n)=f(n-1)+f(n-2)
     *
     * @param target
     * @return
     */
    public static int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }


    public static int jumFloor2(int target){
        Runtime r=Runtime.getRuntime();
        long r1 = r.freeMemory();
        long l = System.currentTimeMillis();
        int [] d=new int[target+1];
        d[1]=1;
        d[2]=2;
        for (int i = 3; i <= target; i++) {
            d[i]=d[i-1]+d[i-2];
        }
        long l1 = System.currentTimeMillis();
        long time=l1-l;
        long r2 = r.freeMemory();
        long memory=r2-r1;
        System.out.println("方法二用时: "+time+" ms");
        System.out.println("方法二用空间: "+memory+" B");
        return d[target];
    }


    public static int jumpFloor3(int target){
        Runtime r=Runtime.getRuntime();
        long r1 = r.freeMemory();
        long l = System.currentTimeMillis();
        if (target <= 2) {
            return target;
        }
        int pre2=1,pre1=2;
        int ans=0;
        for (int i = 3; i <=target ; i++) {
            ans=pre2+pre1;
            pre2=pre1;
            pre1=ans;
        }
        long l1 = System.currentTimeMillis();
        long r2 = r.freeMemory();
        long time=l1-l;
        long memory=r2-r1;
        System.out.println("方法三用时: "+time+" ms");
        System.out.println("方法三用空间: "+memory+" B");
        return ans;
    }
}
