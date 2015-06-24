package io.github.eternalpro.service;

import io.github.eternalpro.dao.UserDao;
import io.github.eternalpro.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/6/16.
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
