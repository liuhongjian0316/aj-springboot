package work.aijiu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;


@EnableOpenApi
@SpringBootApplication
@MapperScan(basePackages = "work.aijiu.dao")
public class AjSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AjSpringbootApplication.class, args);
    }

}
