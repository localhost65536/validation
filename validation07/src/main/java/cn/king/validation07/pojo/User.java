package cn.king.validation07.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/21 22:22
 * @version: 1.0.0
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NotBlank
    private String name;

    @Min(18)
    private Integer age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    @Email(message = "邮箱格式错误")
    private String email;

}
