package cn.supercop.modelfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhouyongcai
 * @create_time 2020/5/28 15:11
 * @note：必须放在所有的mapper、server以及controller包的前面包中，否则无法读取到相应的类
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录:。
     *  这里指定了cn.supercop.controller包下的所有接口对外开放。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.supercop.modelfactory.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("模型工厂数据源注册调用RESTful APIs")
                .description("接口如果存在问题，请访问对公司官网：http://www.supercop.cn")
                .termsOfServiceUrl("http://www.supercop.cn")
                .version("1.0")
                .build();
    }

}
