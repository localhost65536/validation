package cn.king.validation09.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/17 13:57
 * @version: 1.0.0
 * @description:
 */
@Configuration
public class BeanConfig {

    /**
     * Spring Validation默认会校验完所有字段，然后才抛出异常。可以通过一些简单的配置，开启failFast模式，一旦校验失败就立即返回。
     * <p>
     * 配置快速失败
     */
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                // 快速失败模式
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

}
