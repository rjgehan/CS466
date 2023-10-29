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

    public void addFiftyToBalance(String username) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            User userToUpdate = findUserByLogin(username);

            if (userToUpdate != null) {
                userToUpdate.setBalance(50.0);  // directly set to 50
                em.merge(userToUpdate);
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to add $50 to balance.", ex);
        } finally {
            em.close();
        }
    }

    public void setBalanceToZero(String username) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            User userToUpdate = findUserByLogin(username);

            if (userToUpdate != null) {
                userToUpdate.setBalance(0.0);
                em.merge(userToUpdate);
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to set balance to zero.", ex);
        } finally {
            em.close();
        }
    }

    public void resetPassword(String username, String newPassword) {
        EntityManager em = getEntityManager();
        try {
            // Start a new transaction
            em.getTransaction().begin();

            // Retrieve the user by username
            User userToUpdate = findUserByLogin(username);

            if (userToUpdate != null) {
                userToUpdate.setPassword(newPassword); // assuming you have a setPassword method in User entity
                em.merge(userToUpdate); // Update the user
            }

            // Commit the transaction
            em.getTransaction().commit();
        } catch (Exception ex) {
            // If there's an exception, roll back the transaction
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to reset password.", ex);
        } finally {
            em.close();
        }
    }

}