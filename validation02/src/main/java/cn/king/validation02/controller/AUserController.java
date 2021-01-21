package cn.king.validation02.controller;

import cn.king.validation02.pojo.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/18 22:16
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/a/user")
public class AUserController {

    /**
     * 使用 @Valid 和 @Validated 都可以。
     * RequestBody参数校验，校验失败会抛出 MethodArgumentNotValidException 异常。
     */
    @PostMapping("/fun1")
    public Object fun1(@RequestBody @Validated User user) {
        // 校验通过，才会执行业务逻辑处理
        return "ok";
    }

}
