package com.kanq.server.sso.controller;

import com.kanq.common.vo.ApiResult;
import com.kanq.server.sso.service.AccountService;
import com.kanq.server.sso.vo.AccountVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@Api(tags = "公共控制器")
@RequestMapping("/public")
public class PublicController {

    @Resource
    private AccountService accountService;

    @GetMapping("helloWorld")
    public String  hellWorld(){
        return "hello World";
    }


    @PostMapping("/register")
    @ApiOperation("注册接口")
    public ApiResult accountRegister(@RequestBody @Valid AccountVo accountVo){
        accountService.accountRegister(accountVo);
        return ApiResult.SUCCESS;
    }
}
