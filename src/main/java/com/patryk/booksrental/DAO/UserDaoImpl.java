package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.User;
import com.patryk.booksrental.Models.UserType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getList() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserByLogin(String login) {
        return entityManager.createQuery("select u from User u where u.login= :login", User.class).
                setParameter("login", login).getSingleResult();
    }

    @Override
    public User getUserByEmail(String email) {
        return entityManager.createQuery("select u from User u where u.email= :email", User.class).
                setParameter("email", email).getSingleResult();
    }

    @Override
    public User getUsetById(long id) {
        return entityManager.createQuery("select u from User u where u.id= :id", User.class).
                setParameter("id", id).getSingleResult();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void updateEmail(long id, String email) {
        User userEntity = entityManager.find(User.class, id);
        userEntity.setEmail(email);
    }

    @Transactional
    @Override
    public void updatePassword(long id, String password) {
        User userEntity = entityManager.find(User.class, id);
        userEntity.setPassword(password);
    }

    @Override
    public void updateUserType(long id, UserType userType) {
        User userEntity = entityManager.find(User.class, id);
        userEntity.setUser_type(userType);
    }

    @Transactional
    @Override
    public void updateUser(long id, User user) {
        User userEntity = entityManager.find(User.class, id);
        userEntity.setName(user.getName());
        userEntity.setLast_name(user.getLast_name());
        userEntity.setEmail(user.getEmail());
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        userEntity.setUser_type(user.getUser_type());
    }
}
