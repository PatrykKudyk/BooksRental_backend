package com.patryk.booksrental.Services;

import com.patryk.booksrental.DAO.UserDao;
import com.patryk.booksrental.Models.User;
import com.patryk.booksrental.Models.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updatePassword(long id, String password) {
        userDao.updatePassword(id, password);
    }

    @Override
    public void updateEmail(long id, String email) {
        userDao.updateEmail(id, email);
    }

    @Override
    public void updateUserType(long id, UserType userType) {
        userDao.updateUserType(id, userType);
    }

    @Override
    public void updateUser(long id, User user) {
        userDao.updateUser(id, user);
    }

    @Autowired
    public void setUserDao(UserDao userDao){this.userDao = userDao;}
}
