package com.cs.wechat.security.repository;

import com.cs.wechat.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jonsy
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
