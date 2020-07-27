package com.my.poc.springbootbeaninjectionruntime;

import com.my.poc.externaluserservice.ExternalUserService;
import com.my.poc.externaluserservice.ExternalUserServiceConfig;
import com.my.poc.springbootbeaninjectionruntime.demo.DemoUserStoreImpl;
import com.my.poc.user.GetActiveUsers;
import com.my.poc.user.UserStore;
import com.my.poc.user.UserStoreRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConfigurationProperties("external-user-service")
    public ExternalUserServiceConfig externalUserServiceConfig() {
        return new ExternalUserServiceConfig();
    }

    @Bean(name="defaultUserStore")
    public UserStore defaultUserStore(
            RestTemplate restTemplate,
            ExternalUserServiceConfig externalUserServiceConfig
    ) {
        return new ExternalUserService(restTemplate, externalUserServiceConfig);
    }

    @Bean(name="demoUserStore")
    public UserStore demoUserStore() {
        return new DemoUserStoreImpl();
    }

    @Bean
    public UserStoreRegistry userStoreRegistry(
            @Qualifier("defaultUserStore") UserStore defaultUserStore,
            @Qualifier("demoUserStore") UserStore demoUserStore
    ){
        return new UserStoreRegistry(defaultUserStore, demoUserStore);
    }

    @Bean
    public GetActiveUsers getActiveUsers(UserStoreRegistry userStoreRegistry) {
        return new GetActiveUsers(userStoreRegistry);
    }
}
