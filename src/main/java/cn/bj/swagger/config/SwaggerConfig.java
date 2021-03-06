package cn.bj.swagger.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.ApiOperation;
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
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2021/10/15 10:57
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api文档的详细信息的方法
                .apiInfo(apiInfo())
                .select()
                // 指定要生成api接口的包路径
//                .apis(RequestHandlerSelectors.basePackage("cn.bj.swagger.controller"))
                //使用了 @ApiOperation 注解的方法生成api接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(PathSelectors.any())
                //可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    /**
     * 设置api文档的详细信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("Spring Boot集成Swagger2")
                // 接口描述
                .description("相关接口描述：")
                // 联系方式
//                .contact("微信公众号" + "全栈学习笔记" + "359076197@qq.com")
                // 版本信息
                .version("1.0")
                // 构建
                .build();
    }
}
