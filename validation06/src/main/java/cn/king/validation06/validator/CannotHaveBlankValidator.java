package cn.king.validation06.validator;

import cn.king.validation06.anno.CannotHaveBlank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/21 22:12
 * @version: 1.0.0
 * @description:
 */
public class CannotHaveBlankValidator implements ConstraintValidator<CannotHaveBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //null时不进行校验
        if (value != null && value.contains(" ")) {

            //获取默认提示信息
            String defaultConstraintMessageTemplate = context.getDefaultConstraintMessageTemplate();
            System.out.println("default message :" + defaultConstraintMessageTemplate);
            //禁用默认提示信息
            context.disableDefaultConstraintViolation();
            //设置提示语
            context.buildConstraintViolationWithTemplate("can not contains blank").addConstraintViolation();
            return false;
        }
        return true;
    }

    @Override
    public void initialize(CannotHaveBlank constraintAnnotation) {

    }

}