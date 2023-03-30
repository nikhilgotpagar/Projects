package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    //fake userlist

    List<User> list = List.of(

            new User(01L, "Nikhil G", 12345),
            new User(02L, "Amit G", 12345),
            new User(03L, "Nick G", 12345),
            new User(04L, "Sam G", 12345)
    );

    @Override
    public User getUser(Long Id) {
        return list.stream().filter(user -> user.getUserId().equals(Id)).findAny().orElse(null);
    }
}
