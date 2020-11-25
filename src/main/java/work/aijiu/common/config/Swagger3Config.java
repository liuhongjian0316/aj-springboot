package work.aijiu.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
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
}
