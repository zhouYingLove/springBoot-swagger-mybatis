package cn.supercop.modelfactory.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhouyongcai
 * @create_time 2020/5/28 16:25
 * @note：
 */
public class TestObj {
    @ApiModelProperty(value = "姓名", example = "阿三", required = true)
    private String name;
    @ApiModelProperty(value = "年龄", example = "22", required = true)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
