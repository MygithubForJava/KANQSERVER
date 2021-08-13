package com.kanq.server.sso.service.nowcode;

import org.junit.experimental.theories.PotentialAssignment;

import java.util.Stack;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/06/16:24
 * @Description:  用两个栈实现一个队列
 */
public class NC76 {


    Stack<Integer> stackIn = new Stack<Integer>();
    Stack<Integer> stackOut = new Stack<Integer>();

    public static void main(String[] args) {
        NC76 nc76=new NC76();
        nc76.push(1);
        nc76.push(2);
        int pop1 = nc76.pop();
        int pop2 = nc76.pop();
        System.out.println(pop1);
        System.out.println(pop2);
    }


    public  void push(int node) {
        stackIn.push(node);
    }

    /**
     *出栈的时候要考虑到栈为空的情况
     * @return
     */
    public int pop() {
        Integer pop=null;
        if (!stackOut.isEmpty()){
            pop = stackOut.pop();
            return pop;
        }else {
            if (stackIn.isEmpty()){
                return -1;
            }else{
            while (!stackIn.isEmpty()){
                Integer out = stackIn.pop();
                stackOut.push(out);
              }
                pop = stackOut.pop();
            }
            return pop;
        }
    }

}
