package com.kanq.server.sso.service.nowcode;

import cn.hutool.core.util.ObjectUtil;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/09/9:28
 * @Description: 二分查找法确定数字下表
 */
public class NC105 {
    public static void main(String[] args) {
        int[] array = {1, 1, 5, 5};
        int search = search(array, 1);
        System.out.println(search);
    }


    public static int search(int[] nums, int target) {
        // write code here
        if (nums.length == 0) {
            return -1;
        }
        int high = nums.length - 1;
        int low = 0;
        int mid = (high + low) / 2;
        if (nums[low] == target) {
            return low;
        }
        if (nums[high] == target) {
            while (nums[high] == nums[high - 1]) {
                high = high - 1;
            }
            return high;
        }
        while (low < high) {
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                while (low < mid) {
                    if (nums[mid] != nums[mid - 1]) {
                        return mid;
                    }
                    mid = mid - 1;
                }
                return mid;
            }
            mid = (high + low) / 2;
        }
        return -1;
    }
}
