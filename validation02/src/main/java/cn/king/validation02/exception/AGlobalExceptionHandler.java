package cn.king.validation02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/16 17:38
 * @version: 1.0.0
 * @description: 全局异常处理器
 * AUserController、BUserController 如果校验失败，会抛出 MethodArgumentNotValidException 或者 ConstraintViolationException 异常。
 * 在实际项目开发中，通常会用统一异常处理来返回一个更友好的提示。
 * 比如我们系统要求无论发送什么异常，http的状态码必须返回200，由业务码去区分系统的异常情况。
 * <p>
 * AGlobalExceptionHandler 和 BGlobalExceptionHandler 注释掉一个进行比较
 */
//@RestControllerAdvice
public class AGlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();

        Map<String, Object> map = new HashMap<>();
        map.put("code", -2);
        map.put("msg", msg);

        return map;

    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", -2);
        map.put("msg", ex.getMessage());
        return map;
    }

}
