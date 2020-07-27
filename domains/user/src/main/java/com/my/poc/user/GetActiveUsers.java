package com.my.poc.user;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetActiveUsers {

    private final UserStoreRegistry userStoreRegistry;

    public List<User> execute(String segment, String profile) {
        UserStore userStore = userStoreRegistry.getUserStore(profile != null ? profile : "default");
        return userStore.getUsers(segment).stream()
                .filter(user -> "ACTIVE".equals(user.getStatus()))
                .collect(Collectors.toList());
    }
}
