package com.my.poc.user;

import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.SimplePluginRegistry;

import static java.util.Arrays.asList;

public class UserStoreRegistry {

    private PluginRegistry<UserStore, String> registry;

    public UserStoreRegistry(UserStore defaultUserStore, UserStore demoUserStore) {
        registry = SimplePluginRegistry.of(asList(defaultUserStore, demoUserStore));
    }

    public UserStore getUserStore(String profile) {
        return registry.getPluginFor(profile).isPresent() ? registry.getPluginFor(profile).get() : null;
    }
}

