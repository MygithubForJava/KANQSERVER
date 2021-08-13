package com.kanq.server.sso.service.nowcode;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/11/9:47
 * @Description: 寻找第k大的数；思路快速排序（快排），双指针
 */

public class NC88 {

    public static void main(String[] args) {
          int[] a={3,7,1,2,9,4,5,3,7};
          int kth = findKth(a, 9, 2);
          System.out.println(kth);
    }


    public static  int findKth(int[] a ,int n,int K){
        Quick_Sort(a,0,n-1);
        int res=a[n-K];
        return res;
    }

    /**
     * 根据下标交换两数
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int [] array,int i,int j){
        int temp=array[j];
        array[j]=array[i];
        array[i]=temp;
    }

    /**
     * 快排，左右指针与哨兵值比较
     * @param array
     * @param l 左边界
     * @param r 右边界
     */
    public static void Quick_Sort(int[] array,int l,int r){
        if (l>=r){return;}
        int i=l;int j=r;
        while (i<j){
            while (i<j&&array[i]<=array[l]) i++;
            while (i<j&&array[j]>=array[l]) j--;
            swap(array,i,j);
        }
           swap(array,l,i);
           Quick_Sort(array,l,i-1);
           Quick_Sort(array,i+1,r);
    }

}
