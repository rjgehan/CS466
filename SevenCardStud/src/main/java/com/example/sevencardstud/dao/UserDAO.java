package com.example.sevencardstud.dao;

import com.example.sevencardstud.model.entity.User;
import com.utils.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/***
 * UserDAO is a subclass of GenericDAO.
 * It is a good practice to extend GenericDAO for each specific entity.
 * This allows adding custom methods for this DAO (mostly, custom list operations).
 */
public class UserDAO extends GenericDAO<User> {

    public UserDAO(){
        super(User.class);
    }

    /***
     * Method used for login, finds the user tied to a specific login.
     * @param login The login which is unique in the DB.
     * @return User entity.
     */
    public User findUserByLogin(String login){
        EntityManager em = getEntityManager();

        String query = "SELECT u FROM User u WHERE u.username = :loginParam"; // :loginParam is a parameter, to avoid SQL Injection
        User found;

        try {
            found = em.createQuery(query, User.class).setParameter("loginParam", login).getSingleResult();
        } catch(NoResultException ex){
            found = null;
        } finally{
            em.close();
        }
        return found;
    }
}