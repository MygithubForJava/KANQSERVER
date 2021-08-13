package com.kanq.common.utils;

import com.kanq.common.vo.AuthVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Mr.huang
 * @Date: 2021/07/28/14:17
 * @Description: token工具类
 */
@Slf4j
public class AuthUtil {

   static final Long EXPIRES=8L;

    /**
     * 根据用户属性生成一个token
     * @param authVO 用户属性
     * @return  token
     */
      public static  String createToken(AuthVO authVO){
         return  null;
      }
}
