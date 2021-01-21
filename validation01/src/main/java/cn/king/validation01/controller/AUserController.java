package cn.king.validation01.controller;

import cn.king.validation01.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/17 17:17
 * @version: 1.0.0
 * @description: 表单校验
 */
@RestController
@RequestMapping("/a/user")
public class AUserController {

    /**
     * @author: wjl@king.cn
     * @createTime: 2021/1/17 17:20
     * @param: user
     * @param: bindingResult
     * @return: java.lang.Object
     * @description: ..
     * 在需要校验的pojo前面加@Validated注解代表校验该参数。
     * 在需要校验的pojo后面加BindingResult参数，用来接收校验出错误时的提示信息。
     *  => @Validated注解和BindingResult参数必须配对使用，并且位置顺序固定。 如果要校验的参数有多个，入参写法：(@Validated Foo foo, BindingResult fooBindingResult, @Validated Bar bar, BindingResult barBindingResult);
     */
    @PostMapping
    public Object addUser(@Validated User user, BindingResult bindingResult) {
        System.out.println(user);
        // 获取校验错误的提示信息
        // 如果有错误提示信息
        if (bindingResult.hasErrors()) {
            // bindingResult.getFieldErrors() 字段的错误
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                // fieldError.getField() 绑定失败的字段名
                // fieldError.getDefaultMessage() 默认的错误提示信息
                System.out.println(fieldError.getField() + " : " + fieldError.getDefaultMessage());
            }
            // bindingResult.getAllErrors() 所有错误
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                System.out.println(objectError.getDefaultMessage());
            }
            return "fail";
        }
        return "success";
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2021/1/17 17:30
     * @param: user
     * @param: bindingResult
     * @return: java.lang.Object
     * @description: ..
     * => @Validated：Spring提供的数据校验
     * => @Valid：JSR303数据校验
     */
    @PutMapping("/fun1")
    public Object updateUser1(@Valid User user, BindingResult bindingResult) {
        System.out.println(user);
        if (bindingResult.getErrorCount() > 0) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                System.out.println(fieldError.getField() + " : " + fieldError.getDefaultMessage());
            }
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                System.out.println(objectError.getDefaultMessage());
            }
            return "fail";
        }
        return "success";
    }

    /**
     * @author: wjl@king.cn
     * @createTime: 2021/1/17 17:31
     * @param: user
     * @param: errors
     * @return: java.lang.Object
     * @description: ..
     * BindingResult 继承了 Errors，所以将入参的BindingResult换成Errors也行
     */
    @PutMapping("/fun2")
    public Object updateUser2(@Valid User user, Errors errors) {
        System.out.println(user);
        if (errors.getErrorCount() > 0) {
            for (FieldError fieldError : errors.getFieldErrors()) {
                System.out.println(fieldError.getField() + " : " + fieldError.getDefaultMessage());
            }
            for (ObjectError objectError : errors.getAllErrors()) {
                System.out.println(objectError.getDefaultMessage());
            }
            return "fail";
        }

        if (errors.hasErrors()) {
            for (FieldError fieldError : errors.getFieldErrors()) {
                System.out.println(fieldError.getField() + " : " + fieldError.getDefaultMessage());
            }
            for (ObjectError objectError : errors.getAllErrors()) {
                System.out.println(objectError.getDefaultMessage());
            }
            return "fail";
        }

        return "success";
    }

    // 避免下面的写法。
    @PutMapping("/fun3")
    public Object updateUser3(@Valid User user) {
        return null;
    }

    /*
     * BindingResult 比  Errors 常用。
     * bindingResult.hasErrors() 比 bindingResult.getErrorCount() 常用。
     */

}
