package cn.king.validation08.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/21 22:27
 * @version: 1.0.0
 * @description:
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public @NotBlank String fun(@Min(18) Integer age) {
        System.out.println("age : " + age);
        return "ok";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, Object> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", 500);
        return map;
    }

}
