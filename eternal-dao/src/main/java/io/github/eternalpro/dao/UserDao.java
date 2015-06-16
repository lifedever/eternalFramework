package io.github.eternalpro.dao;

import io.github.eternalpro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by gefangshuai on 2015/6/16.
 */
public interface UserDao extends JpaRepository<User, Long>,JpaSpecificationExecutor<User> {
}
