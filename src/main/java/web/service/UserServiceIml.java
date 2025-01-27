package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceIml implements UserService {
    @Autowired
    private UserDao userDao;


    @Transactional(readOnly = true)
    @Override
    public List<User> allUser() {
        return userDao.allUser();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Transactional
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
