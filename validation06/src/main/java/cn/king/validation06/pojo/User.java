package cn.king.validation06.pojo;

import cn.king.validation06.anno.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/21 22:08
 * @version: 1.0.0
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //@Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    //@NotBlank(message = "手机号码不能为空")
    // 通过自定义注解代替上面两行
    @Phone
    private String phone;

}
