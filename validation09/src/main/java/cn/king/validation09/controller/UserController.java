package cn.king.validation09.controller;


import cn.king.validation09.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/17 13:54
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Validator globalValidator;

    /**
     * 编程式校验
     */
    @PostMapping
    public Object add(@RequestBody User user) {
        Set<ConstraintViolation<User>> validate = globalValidator.validate(user, User.Save.class);
        // 如果校验通过，validate为空；否则，validate包含未校验通过项
        if (validate.isEmpty()) {
            // 校验通过，才会执行业务逻辑处理
        } else {
            for (ConstraintViolation<User> userConstraintViolation : validate) {
                // 校验失败，做其它逻辑
                System.out.println(userConstraintViolation);
                // throw new RuntimeException();
            }
        }
        return "ok";
    }

}
