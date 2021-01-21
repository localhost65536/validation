package cn.king.validation06.anno;

import cn.king.validation06.validator.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/21 22:10
 * @version: 1.0.0
 * @description: 自定义校验注解。字段必须是手机号。
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    /**
     * 校验不通过的message
     */
    String message() default "请输入正确的手机号";

    /**
     * 分组校验
     */
    Class<?>[] groups() default { };


    Class<? extends Payload>[] payload() default { };

}