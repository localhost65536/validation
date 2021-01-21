package cn.king.validation02.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
//@RestControllerAdvice
public class BGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object notValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.info("请求的url为{}出现数据校验异常,异常信息为:", request.getRequestURI(), e);
        BindingResult bindingResult = e.getBindingResult();
        List<String> errorMsgList = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMsgList.add(fieldError.getDefaultMessage());
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", errorMsgList);

        return map;
    }

}
