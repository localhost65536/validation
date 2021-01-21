package cn.king.validation02.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/18 22:16
 * @version: 1.0.0
 * @description:
 */
@Validated
@RestController
@RequestMapping("/b/user")
public class BUserController {

    // RequestMapping / PathVariable 参数校验。校验失败会抛出 ConstraintViolationException 异常。
    @GetMapping("/fun2/{userId}")
    public Object fun2(@PathVariable @Min(10000L) Long userId) {
        // 校验通过，才会执行业务逻辑处理
        return "ok";
    }

    // RequestMapping / PathVariable 参数校验。校验失败会抛出 ConstraintViolationException 异常。
    @GetMapping("fun3")
    public Object fun3(@Length(min = 5, max = 10) @NotNull String username) {
        // 校验通过，才会执行业务逻辑处理
        return "ok";
    }

}
