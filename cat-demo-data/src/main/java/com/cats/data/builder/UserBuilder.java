package com.cats.data.builder;

import com.cats.data.entity.User;

import java.util.UUID;

public class UserBuilder {

    public static User of(String first, String last) {
        return of(UUID.randomUUID().toString(), first, last);
    }

    public static User of(String id, String first, String last) {
        User user = new User();
        user.setId(id);
        user.setFirst(first);
        user.setLast(last);
        return user;
    }
}
