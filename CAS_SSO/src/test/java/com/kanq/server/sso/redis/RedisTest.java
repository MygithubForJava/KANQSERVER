package com.kanq.server.sso.redis;

import com.kanq.common.entity.sso.Account;
import com.kanq.common.utils.JedisUtils;
import com.kanq.server.sso.service.imp.NsLisSolution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {




    @Test
    public void testJedisUtil(){
        JedisUtils.delKey("jedis");
        System.out.println("删除成功");
        JedisUtils.setValue("jedisUtils","配置成功");
        String jedisUtils = JedisUtils.getStringValue("jedisUtils");
        boolean b = JedisUtils.existKey("jedisUtils");
        JedisUtils.expire("jedisUtils",10l);
        Long ttl = JedisUtils.getExpireTime("jedisUtils");
        System.out.println(ttl);
        System.out.println(b);
        System.out.println(jedisUtils);

        Map<String,String> accountMap=new HashMap<>();
        accountMap.put("accountId","1");
        accountMap.put("nickName","1234");
        accountMap.put("deptName","123456");
        JedisUtils.setValue("user1-key",accountMap);
        Map<String, String> mapValue = JedisUtils.getMapValue("user1-key");
        String account = mapValue.get("accountId");
        System.out.println(account);
        System.out.println(mapValue);
        Long ttl1 = JedisUtils.getExpireRemainingTime("jedisUtils");
        try {
            Thread.sleep(5l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long ttl2 = JedisUtils.getExpireRemainingTime("jedisUtils");
        System.out.println(ttl1);
        System.out.println(ttl2);
    }


    @Test
    public void testNIUKE(){

        int a =2;
        int b=3;

        StringBuilder ab=new StringBuilder(String.valueOf(a));
        StringBuilder ba=new StringBuilder(String.valueOf(b));
        for (int i = 0; i < b-1; i++) {
            ab.append(a);
        }
        for (int i = 0; i < a-1; i++) {
            ba.append(b);
        }
        System.out.println(Integer.valueOf(ab+"")+Integer.valueOf(ba+""));
    }


    @Test
    public void testNIUKE02(){
           String n="50";
           Integer length=0;
           Integer na= Integer.valueOf(n);
           Integer  [] aa=new Integer[na];
           Integer  [] bb=new Integer[na];
        for (int i = 0; i < na ; i++) {
              aa[i]=i+1;
              Integer mod=aa[i]%10;
              Integer yu=aa[i]/10;
               Integer sum =mod;
            while (yu!=0){
               mod=yu%10;
               sum=sum+mod;
               yu=yu/10;
            }
            bb[i]=sum;
        }

        List<Integer> lengthList= new ArrayList();
        lengthList.add(0);


        for (int i = 0; i < bb.length-1; i++) {
              if (bb[i]!=bb[i+1]-1){
                  lengthList.add(i);
              }
          }

        if (lengthList.size()==1){
            lengthList.add(bb.length-1);
        }

        Integer [] integers = lengthList.toArray(new Integer[lengthList.size()]);

        List<Integer> chazhiList=new ArrayList<>();
        for (int i = 1; i <integers.length; i++) {
            chazhiList.add(integers[i]-integers[i-1]+1);
        }
        Integer integer = chazhiList.stream().max(Integer::max).get();
        System.out.println(integer);

    }


    @Test
    public void testMode(){
        Integer [] aa=new Integer[1234];
        for (int i = 0; i < aa.length; i++) {
             aa[i]=i+1;
        }
        //System.out.println(Arrays.toString(aa));
        Integer[] integerArrayNew = NsLisSolution.getIntegerArrayNew(aa);
        //System.out.println(Arrays.toString(integerArrayNew));
        System.out.println(Collections.max(Arrays.asList(integerArrayNew)));
    }

    @Test
    public void testStreamChar(){
        int a=1234;
        String aa=a+"";
        int sum = aa.chars().map(c -> c - '0').sum();
        System.out.println(sum);
    }

    @Test
    public void testNS(){
        String a="110328324";
        Integer [] integers=new Integer[Integer.valueOf(a)];
        for (int i = 0; i <integers.length; i++) {
            Integer sum = (i+1+"").chars().map(c -> c - '0').sum();
            integers[i]=sum;
        }
        System.out.println(Collections.max(Arrays.asList(integers)));
    }


    @Test
    public void testNs(){
        String a="112345667";
        int[] ints = a.chars().map(c->c-'0').toArray();
        System.out.println(Arrays.toString(ints));
        int length = ints.length;
        int temp=(ints[0]-1)+9*(length-1);
        int sum =a.chars().map(c->c-'0').sum();
        if (temp>sum){
            System.out.println(temp);
        }else {
            System.out.println(sum);
        }
    }

}


