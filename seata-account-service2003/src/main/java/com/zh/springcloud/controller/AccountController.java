package com.zh.springcloud.controller;

import com.zh.springcloud.dao.CommonResult;
import com.zh.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author 卓少武
 * @date 2020/10/20
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功");
    }

}
