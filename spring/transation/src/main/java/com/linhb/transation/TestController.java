package com.linhb.transation;

import com.linhb.transation.dao.UserDao;
import com.linhb.transation.entity.User;
import com.linhb.transation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author linhb
 * @Date 2020/6/9
 **/
@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private TestController testController;

    @RequestMapping("/test")
    public void saveList(){
        userService.saveList();
    }

    @RequestMapping("/test2")
    public void saveListRollback(){
        userService.saveListRollback();
    }

}
