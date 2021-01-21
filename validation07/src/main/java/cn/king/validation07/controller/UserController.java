package cn.king.validation07.controller;

import cn.king.validation07.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/21 22:23
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    Validator globalValidator;

    @GetMapping
    public Object fun1() {
        User user = new User();
        user.setAge(20);
        user.setEmail("10086");

        Set<ConstraintViolation<User>> set = globalValidator.validate(user);
        for (ConstraintViolation<User> constraintViolation : set) {
            System.out.println(constraintViolation.getMessage());
        }

        return "ok";

    }

    public static void main(String[] args) {
        User user = new User();
        user.setAge(20);
        user.setEmail("10086");

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<User>> set = validator.validate(user);
        for (ConstraintViolation<User> constraintViolation : set) {
            System.out.println(constraintViolation.getMessage());
        }
    }

}
