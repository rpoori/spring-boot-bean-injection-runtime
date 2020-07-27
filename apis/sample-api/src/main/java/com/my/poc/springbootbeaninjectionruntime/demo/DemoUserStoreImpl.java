package com.my.poc.springbootbeaninjectionruntime.demo;

import com.my.poc.user.User;
import com.my.poc.user.UserStore;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class DemoUserStoreImpl implements UserStore {

    @Override
    public List<User> getUsers(String segment) {
        User user1 = User.builder()
                .id("user-id-1")
                .name("user-name-1")
                .email("user-email-1@test.com")
                .status("ACTIVE")
                .build();

        User user2 = User.builder()
                .id("user-id-2")
                .name("user-name-2")
                .email("user-email-2@test.com")
                .status("ACTIVE")
                .build();

        User user3 = User.builder()
                .id("user-id-3")
                .name("user-name-3")
                .email("user-email-3@test.com")
                .status("ACTIVE")
                .build();

        return asList(user1, user2, user3);
    }

    @Override
    public boolean supports(String profile) {
        return "demo".equals(profile);
    }
}
