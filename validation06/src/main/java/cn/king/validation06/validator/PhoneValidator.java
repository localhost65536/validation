package cn.king.validation06.validator;

import cn.king.validation06.anno.Phone;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/21 22:11
 * @version: 1.0.0
 * @description:
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        if (!StringUtils.isEmpty(phone)) {

            //获取默认提示信息
            String defaultConstraintMessageTemplate = constraintValidatorContext.getDefaultConstraintMessageTemplate();
            System.out.println("default message :" + defaultConstraintMessageTemplate);
            //禁用默认提示信息
            constraintValidatorContext.disableDefaultConstraintViolation();
            //设置提示语
            constraintValidatorContext.buildConstraintViolationWithTemplate("手机号格式错误").addConstraintViolation();

            String regex = "^1(3|4|5|7|8)\\d{9}$";
            return phone.matches(regex);
        }
        return true;
    }

    @Override
    public void initialize(Phone constraintAnnotation) {

    }

}
