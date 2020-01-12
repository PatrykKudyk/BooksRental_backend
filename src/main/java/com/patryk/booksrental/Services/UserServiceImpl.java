package com.patryk.booksrental.Services;

import com.patryk.booksrental.DAO.UserDao;
import com.patryk.booksrental.Models.User;
import com.patryk.booksrental.Models.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<User> getUserByLogin(String login) {
        List<User> userList = userDao.getList();
        Stream<User> userStream = userList.stream();
        if(login != null){
            userStream = userStream.filter(user -> user.getLogin().equals(login));
        }
        return userStream.collect(Collectors.toList());
    }

    @Override
    public List<User> getUserByEmail(String email) {
        List<User> userList = userDao.getList();
        Stream<User> userStream = userList.stream();
        if(email != null){
            userStream = userStream.filter(user -> user.getEmail().equals(email));
        }
        return userStream.collect(Collectors.toList());
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
