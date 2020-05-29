package cn.supercop.modelfactory.pojo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Bean;

/**
 * @author zhouyongcai
 * @create_time 2020/5/28 11:39
 * @note：
 */
public class InterfaceResultObj {
    @ApiModelProperty(value = "是否成功", example = "true: 成功，false：失败", dataType = "boolean")
    private Boolean isSuccess;
    @ApiModelProperty(value = "接口错误异常", example = "java.lang.NullPointerException", dataType = "string", allowEmptyValue = true)
    private String exception;

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "InterfaceResultObj{" +
                "isSuccess=" + isSuccess +
                ", exception='" + exception + '\'' +
                '}';
    }
}
