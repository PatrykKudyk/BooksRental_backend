package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.User;
import com.patryk.booksrental.Models.UserType;

import java.util.List;

public interface UserDao {
    List<User> getList();
    User getUserById(long id);
    User getUserByLogin(String login);
    User getUserByEmail(String email);
    void addUser(User user);
    void updatePassword(long id, String password);
    void updateEmail(long id, String email);
    void updateUserType(long id, UserType userType);
    void updateUser(long id, User user);
}
