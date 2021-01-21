package cn.king.validation04.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: wjl@king.cn
 * @time: 2021/1/18 23:05
 * @version: 1.0.0
 * @description: 如果POJO中包含了自定义的实体类，就需要用到嵌套校验。
 * POJO中的某个字段也是一个对象，这种情况下，可以使用嵌套校验。
 */
@Data
public class User {

    @Min(value = 1L, groups = Update.class)
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
     * 此时DTO类的对应字段必须标记@Valid注解
     */
    @Valid
    @NotNull(groups = {Save.class, Update.class})
    private Job job;

    @Data
    public static class Job {

        @NotNull(groups = {Update.class})
        @Min(value = 1, groups = Update.class)
        private Long jobId;

        @NotNull(groups = {Save.class, Update.class})
        @Length(min = 2, max = 10, groups = {Save.class, Update.class})
        private String jobName;

        @NotNull(groups = {Save.class, Update.class})
        @Length(min = 2, max = 10, groups = {Save.class, Update.class})
        private String position;
    }

    /**
     * 保存的时候校验分组
     */
    public interface Save {
    }

    /**
     * 更新的时候校验分组
     */
    public interface Update {
    }

}
