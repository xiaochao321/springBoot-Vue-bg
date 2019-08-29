package com.yuanjun.mybatis.repository;

import com.yuanjun.mybatis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author shimh
 * <p>
 * 2018年1月23日
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByAccount(String account);

}
