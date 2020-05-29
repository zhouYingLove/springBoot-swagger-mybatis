package cn.supercop.modelfactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhouyongcai
 * @create_time 2020/5/28 14:46
 * @note：spring boot 启动项 必须放在所有的mapper、server以及controller包的前面包中，否则无法读取到相应的类
 */
@SpringBootApplication
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class);
    }
}
