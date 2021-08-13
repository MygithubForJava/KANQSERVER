package com.kanq.server.sso.service;


import com.kanq.server.sso.vo.AccountVo;

public interface AccountService {

    /**
     * 用户注册
     * @param accountVo
     */
    void accountRegister(AccountVo accountVo);

    /**
     * 通过useName获取AccountVo
     * @param name
     * @return
     */
    AccountVo getAccountVoByName(String name);
}
