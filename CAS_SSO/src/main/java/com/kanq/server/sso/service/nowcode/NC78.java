package com.kanq.server.sso.service.nowcode;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;

import java.util.List;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/06/9:20
 * @Description:
 */
public class NC78 {
    /**
     * 链表结构
     */
    @Data
    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 链表反转[1,2,3] ->[3,2,1]
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {

        if (head == null)
            return head;
        ListNode pre = head;// 上一结点
        ListNode cur = head.getNext();// 当前结点
        ListNode tmp;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur != null) {// 当前结点为null，说明位于尾结点
            tmp = cur.getNext();
            cur.setNext(pre);// 反转指针域的指向

            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.setNext(null);

        return pre;

    }

    /**
     * 快满指针判断链表是否有环
     * @param head
     * @return
     */
    public  static Boolean hasCycle(ListNode head){
        if (null==head){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
      while (slow.next!=null&&fast.next!=null&&fast.next.next!=null){
          slow=slow.next;
          fast=fast.next.next;
          if (slow==fast){
              return true;
          }
      }
        return  false;
    }



    public static void main(String[] args) {

        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);

        ListNode head=new ListNode(0);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        ListNode h=head;
        System.out.println("******");
        while (null!=h){
            System.out.print(h.getVal()+" ");
            h=h.getNext();
        }
        System.out.println("\n******");
        ListNode listNode = ReverseList(head);
        while (null!=listNode){
            System.out.print(listNode.getVal()+" ");
            listNode=listNode.getNext();
        }
        System.out.println("\n******");

        Boolean aBoolean = hasCycle(listNode);
        System.out.println(aBoolean);
    }
}
