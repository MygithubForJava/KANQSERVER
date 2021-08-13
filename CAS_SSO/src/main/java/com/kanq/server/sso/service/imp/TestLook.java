package com.kanq.server.sso.service.imp;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.huang
 * @Date: 2021/07/29/16:58
 * @Description:  观察者模式实例
 */

public class  TestLook{

    public static void main(String[] args) {
          User one = new UserImplOne();
          User two = new UserImplTwo();
          Subject subject=new subjectServer();
          subject.addObsever(one);
          subject.addObsever(two);
          subject.doSomething();
    }
}

abstract class Subject {
    private List<User> userList = new ArrayList<>();
    public  void addObsever(User user){
        userList.add(user);
    }

    public  void deleteUser(User user){
        userList.remove(user);
    }

    public void  notifyObserver(){
        for (User user : userList) {
            user.update();

        }

    }
    abstract void doSomething();
}


class subjectServer extends Subject{

    @Override
    void doSomething() {
        System.out.println("被观察者发生变化");
        this.notifyObserver();
    }
}


interface User{
    void update();
}

class UserImplOne implements  User{
    @Override
    public void update() {
        System.out.println("观察者1收到改变通知");
    }
}


class UserImplTwo implements  User{
    @Override
    public void update() {
        System.out.println("观察者2收到改变通知");
    }
}