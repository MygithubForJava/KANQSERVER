package com.kanq.server.sso.service.nowcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/10/15:19
 * @Description:  NC119 最小的K个数
 */
public class NC119 {





    public static void main(String[] args) {
        int[] array={3,2,1,4,8,7};
        int[] ints = Bubble_Sort(array);
        System.out.println(Arrays.toString(ints));
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(array, 3);
        System.out.println(arrayList);
        merge(array,array.length,array,array.length);
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer>arrayList=new ArrayList<>(k);
        int[] ints = Bubble_Sort(input);
        for (int i = 0; i < k; i++) {
             arrayList.add(ints[i]);
        }
        return  arrayList;
    }


    public static int[]  Bubble_Sort(int[] input){
        for (int i = input.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (input[j]>input[j+1]){
                    int temp=0;
                    temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
        return  input;
    }


    public static void merge(int A[], int m, int B[], int n) {
        int[] ints = Arrays.copyOf(A, m + n);
        A=ints;
        int index=m+n-1;
        m--;
        n--;
        while (m>=0&&n>=0){
            if (A[m]>B[n]){
                A[index]=A[m];
                m--;
            }else {
                A[index]=B[n];
                n--;
            }
            index--;
        }
        while (n>=0){
            A[index]=B[n];
            n--;
            index--;
        }
        System.out.println(Arrays.toString(A));
    }
}
