package cn.king.validation05.controller;

import cn.king.validation05.pojo.User;
import cn.king.validation05.pojo.ValidationList;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/valid/list")
public class ValidationListController {

    @PostMapping
    public Object saveList(@RequestBody @Validated ValidationList<User> userList) {
        // 校验通过，才会执行业务逻辑处理
        return "ok";
    }

}