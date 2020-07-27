package com.my.poc.user;

import org.springframework.plugin.core.Plugin;

import java.util.List;

public interface UserStore extends Plugin<String> {
    List<User> getUsers(String segment);
}
