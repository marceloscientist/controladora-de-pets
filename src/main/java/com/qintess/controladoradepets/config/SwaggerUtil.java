package com.qintess.controladoradepets.config;

import java.util.Arrays;
import java.util.List;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerUtil {
    public static Docket returnSwaggerApiWithoutAuthorization(String apiName) {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().apiInfo(getApiInformation(apiName));
    }

    public static Docket returnSwaggerApi(String apiName) {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInformation(apiName))
                .securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey())).select()
                .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }

    private static SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private static ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private static List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    @SuppressWarnings("deprecation")
    public static ApiInfo getApiInformation(String apiName) {
        return new ApiInfo(apiName, "API Rest para Pets", "1.0", "PetsQuintes",
                null, null, null);
    }
}