package cn.king.validation03.controller;


import cn.king.validation03.pojo.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/16 17:50
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public Object saveUser(@RequestBody @Validated(User.Save.class) User user) {
        // 校验通过，才会执行业务逻辑处理
        return "ok";
    }

    @PutMapping
    public Object updateUser(@RequestBody @Validated(User.Update.class) User user) {
        // 校验通过，才会执行业务逻辑处理
        return "ok";
    }

}
