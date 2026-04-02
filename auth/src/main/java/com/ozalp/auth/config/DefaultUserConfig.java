package com.ozalp.auth.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class DefaultUserConfig {

    @Value("${default_user.name}")
    private String name;
}
