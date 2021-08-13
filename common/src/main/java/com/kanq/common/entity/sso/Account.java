package com.kanq.common.entity.sso;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@TableName("account")
@EqualsAndHashCode
public class Account {

    @TableId
    private  Integer accountId;

    private String username;

    private String password;

    private String nickname;

    private  String deptName;

    private Integer type;

    @TableField(fill=FieldFill.INSERT)
    private Date createTime;
    @TableField(fill= FieldFill.INSERT_UPDATE)
    private  Date updateTime;
    @TableLogic
    private  Integer isDel;
}
