package cn.king.validation01.controller;

import cn.king.validation01.pojo.User;
import cn.king.validation01.vo.RestResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/17 17:17
 * @version: 1.0.0
 * @description: RequestBody校验
 */
@RestController
@RequestMapping("/b/user")
public class BUserController {

    @PostMapping(value = "/fun1")
    public ResponseEntity<RestResult<Object>> addUser(@Validated @RequestBody User user, BindingResult bindingResult) {
        System.out.println(user);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(getValidateError(bindingResult), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return ResponseEntity.ok(RestResult.ok());
    }

    @PutMapping(value = "/fun2")
    public RestResult<Object> updateUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        System.out.println(user);
        if (bindingResult.hasErrors()) {
            return getValidateError(bindingResult);
        }
        return RestResult.ok();
    }

    // 下面写法正确
    // 校验失败会抛出 MethodArgumentNotValidException 异常
    @PutMapping(value = "/fun3")
    public RestResult<Object> updateUser2(@Valid @RequestBody User user) {
        return null;
    }

    /**
     * 该方法可封装成工具类
     */
    static public RestResult<Object> getValidateError(BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            return null;
        }

        Map<String, String> fieldErrors = new HashMap<>();

        for (FieldError error : bindingResult.getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getCode() + " | " + error.getDefaultMessage());
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("fieldErrors", fieldErrors);

        return RestResult.error(HttpStatus.UNPROCESSABLE_ENTITY.value(), "参数错误", result);
    }

}
