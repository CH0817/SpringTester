package tw.com.rex.springtester.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.com.rex.springtester.dao.UserDao;
import tw.com.rex.springtester.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService {

    private UserDao userDao;

    @Autowired
    public BaseServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public long count() {
        System.out.println("BaseService.count()");
        return userDao.count();
    }
}
