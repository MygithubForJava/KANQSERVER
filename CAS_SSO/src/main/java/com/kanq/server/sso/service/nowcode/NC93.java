package com.kanq.server.sso.service.nowcode;

import java.util.*;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/06/13:22
 * @Description: 链表模拟LRU算法。缓存最近最少使用淘汰原则
 */

public class NC93 {
    public static void main(String[] args) {
        // 动态初始化 和 静态初始化
        // int [][] aa=new int[][]{{1,1,1},{2,1}};
        int [][] aa={{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int[] lru = LRU(aa, 3);
        System.out.println(Arrays.toString(lru));
    }

    public static int[] LRU(int[][] operators,int k){
        LRUCache cache=new LRUCache(k);
        List<Integer> list=new ArrayList<>();
        for (int[] operator : operators) {
            int opt = operator[0];
            int key = operator[1];
            switch (opt){
                case 1:
                    int val = operator[2];
                    cache.put(key,val);
                    break;
                case 2:
                    list.add(cache.get(key));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }


}

class   LRUCache{
    int cap;
    Map<Integer,Node> map;
    DoubleList cache;

    public LRUCache(int capacity){
        this.cap=capacity;
        this.map=new HashMap<>();
        this.cache=new DoubleList();
    }

    public int get(int key){
        if (map.containsKey(key)){
            Node node = map.get(key);
            cache.remove(node);
            cache.addFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key,int val){
        Node node = new Node(key, val);
        if (map.containsKey(key)){
            cache.remove(map.get(key));
        }else if(cache.size ==cap){
            Node last = cache.tail;
            cache.remove(last);
            map.remove(last.key);
        }
        cache.addFirst(node);
        map.put(key,node);
    }
}

class Node{
        int key,val;
        Node pre,next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
}

class DoubleList{

    Node head,tail;
    int size;
    public  void addFirst(Node node){
        if (head==null){
          head=tail=node;
        }else {
          head.pre=node;
          node.next=head;
          head=node;
        }
        size++;
    }

    public void remove(Node node){
        if (head==node&&tail==node){
            head=tail=node;
        } else if (head==node){
            head.next.pre=null;
            head=head.next;
        }else if (tail==node){
            tail.pre.next=null;
            tail=tail.pre;
        }else {
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }
        size--;
    }
}