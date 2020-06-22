package com.linhb.transation.service;

import com.linhb.transation.dao.UserDao;
import com.linhb.transation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;

/**
 * @Author linhb
 * @Date 2020/6/9
 **/
@Service
public class UserService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = RuntimeException.class,propagation = Propagation.REQUIRED)
    public void saveListRollback(){
        for(int i= 0;i<5;i++){
            User user = new User();
            user.setName("a"+i);

            if (i == 2) {
                throw new RuntimeException();
            }
            userDao.save(user);
        }
    }

    @Transactional
    public void saveList(){
        for(int i= 0;i<5;i++){
            User user = new User();
            user.setName("a"+i);
            try {
                userService.saveUser(user,i);
            } catch (Exception e) {
                System.out.println("异常=====》继续执行");
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                continue;
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveUser(User user,int num){
        userDao.save(user);
        if(num == 2){
            throw new RuntimeException();
        }

    }
}
