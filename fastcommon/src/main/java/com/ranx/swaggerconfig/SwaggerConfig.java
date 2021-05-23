package com.ranx.swaggerconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * http://127.0.0.1:8070/v2/api-docs
 * http://127.0.0.1:8070/doc.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ranx"))
                .paths(PathSelectors.any())
                .build().securityContexts(securityContexts()).securitySchemes(security());
    }

    
    /**
     * 获取swagger创建初始化信息
     * @return
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("ranx", "", "ranx@163.com.cn");
        return new ApiInfoBuilder()
        		.title("swagger 测试文档")
        		.description("dev by ranx")
        		.contact(contact)
                .version("1.0.0").build();
    }

    /**
     * 安全认证参数
     * @return
     */
    private List<ApiKey> security() {
        List<ApiKey> list=new ArrayList<>();
        list.add(new ApiKey("X-ACCESS-TOKEN", "X-ACCESS-TOKEN", "header"));
        return list;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts=new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences=new ArrayList<>();
        securityReferences.add(new SecurityReference("X-ACCESS-TOKEN", authorizationScopes));
        return securityReferences;
    }


    /**
     * 构建全局参数列表
     * @return
     */
    private List<Parameter> globalParamBuilder(){
        List<Parameter> pars = new ArrayList<>();
        pars.add(parameterBuilder("X-ACCESS-TOKEN","令牌","string","header",false).build());
        return pars;
    }

    /**
     * 创建参数
     * @return
     */
    private ParameterBuilder parameterBuilder(String name, String desc, String type , String parameterType, boolean required) {
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name(name).description(desc).modelRef(new ModelRef(type)).parameterType(parameterType).required(required).build();
        return tokenPar;
    }

    /**
     * 创建全局响应值
     * @return
     */
    private List<ResponseMessage> responseBuilder() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(0).message("业务处理成功").build());
        responseMessageList.add(new ResponseMessageBuilder().code(1).message("业务处理失败").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").build());
        return responseMessageList;
    }
	
}
