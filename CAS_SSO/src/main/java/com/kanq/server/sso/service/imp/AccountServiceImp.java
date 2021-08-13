package com.kanq.server.sso.service.imp;

import com.kanq.common.utils.JedisUtils;
import com.kanq.server.sso.service.AccountService;
import com.kanq.server.sso.vo.AccountVo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountServiceImp implements AccountService {


    @Override
    public void accountRegister(AccountVo accountVo) {

    }


    @Override
    public AccountVo getAccountVoByName(String name) {
        AccountVo vo=new AccountVo();
        boolean flag = JedisUtils.existKey(name);
        if (flag){
            Map mapValue = JedisUtils.getMapValue(name);
            mapValue.get("username");
        }
        return null;
    }
}
