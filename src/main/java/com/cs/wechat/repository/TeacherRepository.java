package com.cs.wechat.repository;

import com.cs.wechat.core.BaseRepository;
import com.cs.wechat.domain.model.Teacher;
import org.springframework.stereotype.Repository;

/**
 * Created by cs on 2017/8/4.
 */
@Repository
public interface TeacherRepository extends BaseRepository<Teacher,Integer> {

}
