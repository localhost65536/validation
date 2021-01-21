package cn.king.validation02.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/17 17:16
 * @version: 1.0.0
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    // 每一个注解都包含了message字段，用于校验失败时作为提示信息。不写message将使用默认的错误提示信息。
    @Size(min = 5, max = 10, message = "请输入5-10个字符的用户名")
    private String username;

    private String password;

    @Min(18)
    private Integer age;

    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    private String phone;

    @Email(message = "邮箱格式错误")
    private String email;

    @NotNull(message = "生日不能为空")
    @Past // 生日必须是一个过去的时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

}
