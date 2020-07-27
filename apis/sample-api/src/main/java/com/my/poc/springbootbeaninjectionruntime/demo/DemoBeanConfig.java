package com.my.poc.springbootdddmultiprofile.demo;

import com.my.poc.user.UserStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static com.my.poc.springbootdddmultiprofile.demo.DemoBeanConfig.demoProfile;

@Configuration
@Profile(demoProfile)
public class DemoBeanConfig {

    static final String demoProfile = "demo";

    @Bean
    public UserStore userStore() {
        return new DemoUserStoreImpl();
    }
}
