package com.liqiang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//用于生成接口文档
//开启tomcat后在http://localhost/swagger-ui.html可以看效果
//再用http://localhost/v2/api-docs得到json数据，复制文本存到本地，再上传到EasyMock可以看效果

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages="com.liqiang.web.controller")
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liqiang.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo(){
        @SuppressWarnings("deprecation")//抑制过时警告
        ApiInfo info=new ApiInfo(
                "这是我的crud测试",
                "描述我的接口,员工的增删改查",
                "版本号",
                "http://www.baidu.com",
                "联系人",
                "apache",//版权
                "http://www.baidu.com");//专业版权的地址
        return info;
    }
}

