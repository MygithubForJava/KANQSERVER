package com.kanq.server.sso.vo;


import com.kanq.common.utils.RegexUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class AccountVo {

    @ApiModelProperty("数据库账户id")
    private Integer accountId;
    @ApiModelProperty("用户名")
    @Pattern(regexp = RegexUtil.ACCOUNT_REG,message = "用户名格式错误")
    @NotBlank(message = "用户名信息不能空")
    private String userName;
    @ApiModelProperty("密码")
    @Pattern(regexp = RegexUtil.PASSWORD_REG,message = "密码格式错误")
    @NotBlank(message = "密码信息不能空")
    private String  passWord;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("部门")
    private String deptName;
    @ApiModelProperty("用户类型 0 普通用户 1 会员用户")
    @NotBlank(message = "密码信息不能空")
    private Integer type;

    private String token;
}
