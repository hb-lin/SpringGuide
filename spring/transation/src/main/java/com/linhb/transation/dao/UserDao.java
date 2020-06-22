package com.linhb.transation.dao;

import com.linhb.transation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author linhb
 * @Date 2020/6/9
 **/
public interface UserDao extends JpaRepository<User, String> {

}
