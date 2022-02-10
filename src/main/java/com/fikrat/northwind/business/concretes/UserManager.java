package com.fikrat.northwind.business.concretes;

import com.fikrat.northwind.business.abstracts.UserService;
import com.fikrat.northwind.core.dataAccess.UserDao;
import com.fikrat.northwind.core.entities.User;
import com.fikrat.northwind.core.utilities.results.DataResult;
import com.fikrat.northwind.core.utilities.results.Result;
import com.fikrat.northwind.core.utilities.results.SuccessDataResult;
import com.fikrat.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("kullanici eklendi.");
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email),"kullanici bulundu.");
    }
}
