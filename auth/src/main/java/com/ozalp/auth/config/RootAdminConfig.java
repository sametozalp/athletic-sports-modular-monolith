package com.ozalp.auth.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class RootAdminConfig {

    @Value("${admin.username}")
    private String username;

    @Value("${admin.email}")
    private String email;

    @Value("${admin.name}")
    private String name;

    @Value("${admin.password}")
    private String password;

}
