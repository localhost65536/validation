package cn.king.validation01.vo;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * <p>Description:
 * HTTP结果封装
 * </p>
 *
 * @author: wjl@king.cn
 * @time: 2020/1/3 20:54
 * @since: 1.0
 */
@Data
public class RestResult<T> implements Serializable {

    private Integer code = HttpStatus.OK.value();
    private String msg;
    private T data;

    public static <T> RestResult<T> error(Integer code, String msg, T data) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setCode(code);
        restResult.setMsg(msg);
        restResult.setData(data);
        return restResult;
    }

    public static <T> RestResult<T> error(Integer code, T data) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setCode(code);
        restResult.setData(data);
        return restResult;
    }

    public static <T> RestResult<T> error(Integer code, String msg) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setCode(code);
        restResult.setMsg(msg);
        return restResult;
    }

    public static <T> RestResult<T> ok() {
        return new RestResult<>();
    }

    public static <T> RestResult<T> ok(String msg) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setMsg(msg);
        return restResult;
    }

    public static <T> RestResult<T> ok(T data) {
        RestResult<T> restResult = new RestResult<>();
        restResult.setData(data);
        return restResult;
    }

}
