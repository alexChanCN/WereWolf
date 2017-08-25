package com.github.binarywang.demo.wechat.security.repository;

import com.github.binarywang.demo.wechat.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jonsy
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
