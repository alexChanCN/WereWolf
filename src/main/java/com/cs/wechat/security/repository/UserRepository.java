package com.cs.wechat.security.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jonsy
 *
 */
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {
    User findByUsername(String username);
}
