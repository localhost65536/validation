package cn.king.validation03.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/17 17:16
 * @version: 1.0.0
 * @description: 有时候，为了区分业务场景，对于不同场景下的数据验证规则可能不一样（例如新增时可以不用传递 ID，而修改时必须传递ID），可以使用分组校验。
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // groups：标识此校验规则属于哪个分组，可以指定多个分组
    @NotNull(groups = Update.class)
    @Min(value = 10000L, groups = Update.class)
    private Long userId;

    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 2, max = 10, groups = {Save.class, Update.class})
    private String userName;

    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 6, max = 20, groups = {Save.class, Update.class})
    private String account;

    @NotNull(groups = {Save.class, Update.class})
    @Length(min = 6, max = 20, groups = {Save.class, Update.class})
    private String password;

    /**
     * 一个校验分组
     * 保存的时候校验分组
     */
    public interface Save {
        // 校验分组中不需要定义任何方法，该接口仅仅是为了区分不同的校验规则
    }

    /**
     * 一个校验分组
     * 更新的时候校验分组
     */
    public interface Update {
    }

}
