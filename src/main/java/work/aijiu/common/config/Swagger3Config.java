package work.aijiu.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * swagger3 配置
 */

@Configuration
public class Swagger3Config {

    /**
     * api
     */
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "work.aijiu";

    /**
     * 版本
     */
    public static final String VERSION = "1.0.1";

    @Bean
    public Docket creatResApi(){
        // 添加请求参数，我们这里把token作为请求头部参数传入后端
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(security());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("aj-springboot 测试")
                .description("API 接口文档")
                .version(VERSION)
                .termsOfServiceUrl("http://www.aijiu.work")
                .contact(new Contact("aijiu", "http://www.aijiu.work", "liuhongjian0316@outlook.com"))
                .build();
    }

    private List<SecurityScheme> security() {
        return newArrayList(
                new ApiKey("token", "token", "header")
        );
    }
}
