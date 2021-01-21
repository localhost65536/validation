package cn.king.validation01.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/18 21:46
 * @version: 1.0.0
 * @description: RequestMapping / PathVariable 参数校验。
 *
 */
@Validated // 此时必须在Controller上标注 @Validated 注解，并在入参上声明约束注解
@RestController
@RequestMapping("/c/user")
public class CUserController {

    // 下面写法正确
    // 校验失败会抛出 ConstraintViolationException 异常。
    @GetMapping("/fun1/{userId}")
    public Object fun1(@PathVariable @Min(1000L) Long userId) {
        // 校验通过才会执行业务逻辑
        return "ok";
    }

    // 下面的写法错误，不能加BindingResult
    @GetMapping("/fun2/{userId}")
    public Object fun2(@PathVariable @Min(1000L) Long userId, BindingResult bindingResult) {
        return null;
    }

    // 下面写法正确
    // 校验失败会抛出 ConstraintViolationException 异常。
    @GetMapping("/fun3")
    public Object fun3(@Length(min = 5, max = 10) @NotNull String username) {
        // 校验通过才会执行业务逻辑
        return "ok";
    }

    // 下面的写法错误，不能加BindingResult
    @GetMapping("/fun4")
    public Object fun4(@Length(min = 5, max = 10) @NotNull String username, BindingResult bindingResult) {
        return null;
    }

}
