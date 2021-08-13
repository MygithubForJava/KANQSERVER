package com.kanq.server.sso.service.nowcode;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/11/14:09
 * @Description: 反转字符串
 */
public class NC103 {


    private static NC103 nc103=new NC103();


    public static void main(String[] args) throws IOException {

        /*BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=in.readLine())!=null){
         StringBuffer stringBuffer=new StringBuffer(str);
         System.out.println(stringBuffer.reverse().toString());
        }*/
        /* String a="abcd124ertda";
          String solve = solve(a);
          String solveByStringBuild = solveByStringBuild(a);
          System.out.println(solve);
          System.out.println(solveByStringBuild);*/

        int abba = nc103.getLongestPalindrome("abba", 4);
        System.out.println(abba);

    }

    public static String solve (String str) {
        // write code here
        char[] chars = str.toCharArray();
        int l=0;
        int r=chars.length-1;
        while (l<r){
            char temp=' ';
            temp=chars[r];
            chars[r]=chars[l];
            chars[l]=temp;
            l++;r--;
        }
        return new String(chars);
    }


    public static String solveByStringBuild(String str){
        StringBuilder stringBuilder=new StringBuilder(str);
        StringBuilder reverse = stringBuilder.reverse();
        return  reverse.toString();
    }


    /**
     * NC17 最长回文子串 获取最长回文子串；回文子串：正反读相同new；
     * @param str
     * @param n
     * @return
     */
    public int getLongestPalindrome(String str, int n) {
        // write code here
        char[] chars = str.toCharArray();
        int res=0;
        for (int i = 1; i < n; i++) {
            res=Math.max(res,expandAroundCenter(chars,i,i));
            res=Math.max(res,expandAroundCenter(chars,i,i+1));
        }
        return res;
    }

    private int expandAroundCenter(char[] s,int left,int right){
        int l=left,r=right;
        while (l>=0&&r<s.length&&s[l]==s[r]){
            l--;
            r++;
        }
        return r-l-1;
    }


}


