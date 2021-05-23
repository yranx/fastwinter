package com.ranx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author ranx
 */
@Component
@ConfigurationProperties(prefix = "fast.token")
@Data
//@RefreshScope
public class AccessTokenConfig {

    /**
     * appId
     */
    private  String appId;

    /**
     * SecretKey
     */
    private  String secretKey;



}
