package com.kanq.server.sso.service.nowcode;

import lombok.Data;

import java.util.*;

/**
 * @Author: Mr.huang
 * @Date: 2021/08/09/14:37
 * @Description:  NC15 求二叉树的层序遍历  给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 * 该二叉树层序遍历的结果是
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */

public class NC15 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode();
        TreeNode treeNode2 = new TreeNode();
        TreeNode treeNode3 = new TreeNode();
        treeNode1.setVal(3);
        treeNode1.setTreeLeft(treeNode2);
        treeNode1.setTreeRight(treeNode3);
        treeNode2.setVal(9);
        treeNode3.setVal(20);
        TreeNode treeNode4 = new TreeNode();
        TreeNode treeNode5 = new TreeNode();
        treeNode3.setTreeLeft(treeNode4);
        treeNode3.setTreeRight(treeNode5);
        treeNode4.setVal(15);
        treeNode5.setVal(17);
        //********************
        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(treeNode1);
        String s = Arrays.toString(arrayLists.toArray());
        System.out.println(s);
        //*****************
        List<Integer> list=new ArrayList<>();
        list.add(treeNode1.val);
        getPathToNode(treeNode1,15,list);
        System.out.println(list);
        //*****公共祖先
        int i = lowestCommonAncestor(treeNode1, 15, 17);
        System.out.println(i);
    }

    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        //queue 先进先出
        Queue<TreeNode> treeNodeQueue=new LinkedList<>();
        treeNodeQueue.add(root);
        ArrayList<ArrayList<Integer>> nodeList=new ArrayList<>();
        if (root==null){return nodeList;}
        while (!treeNodeQueue.isEmpty()){
            int size=treeNodeQueue.size();
            ArrayList<Integer> arrayList=new ArrayList<>();
            while (size-- >0){
                TreeNode t = treeNodeQueue.poll();
                arrayList.add(t.val);
                if (t.getTreeLeft()!=null){
                    treeNodeQueue.add(t.getTreeLeft());
                }
                if (t.getTreeRight()!=null){
                    treeNodeQueue.add(t.getTreeRight());
                }
            }
            nodeList.add(arrayList);
        }
        return nodeList;
    }


    public static boolean getPathToNode(TreeNode root, int node, List<Integer> path){
       if (root.val==node){
           return true;
       }
       if (root.treeLeft!=null){
            path.add(root.treeLeft.val);
           if (getPathToNode(root.treeLeft,node,path)){
               return true;
           }else {
               path.remove(path.size()-1);
           }
       }
        if (root.treeRight!=null){
            path.add(root.treeRight.val);
            if (getPathToNode(root.treeRight,node,path)){
                return true;
            }else {
                path.remove(path.size()-1);
            }
        }
       return false;
    }

    public  static int lowestCommonAncestor(TreeNode root,int o1,int o2){
        List<Integer> pathOne=new ArrayList<>();
        List<Integer> pathTwo=new ArrayList<>();
        pathOne.add(root.val);
        pathTwo.add(root.val);
        getPathToNode(root,o1,pathOne);
        getPathToNode(root,o2,pathTwo);
        int res=0;
        for (int i = 0; i < pathOne.size()&&i<pathTwo.size(); i++) {
            if (pathOne.get(i)==pathTwo.get(i)){
                res= pathOne.get(i);
            }else {
                break;
            }
        }
        return res;
    }
}

@Data
class TreeNode{
   int val;
   TreeNode treeLeft;
   TreeNode treeRight;
}
