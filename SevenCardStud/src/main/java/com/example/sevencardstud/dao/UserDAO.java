package com.example.sevencardstud.dao;

import com.example.sevencardstud.model.entity.User;
import com.utils.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

import static java.sql.DriverManager.getConnection;


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

        String query = "SELECT u FROM User u WHERE u.username = :loginParam";
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
                userToUpdate.setBalance(50.0);
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

    public void addAmountToBalance(String username, double amount)
    {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            User user = findUserByLogin(username);

            if(user != null) {
                double currentBalance = user.getBalance();
                user.setBalance(currentBalance + amount);
                em.merge(user);
            }
        }
        catch(Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to add amount to user's balance.", ex);
        }
        finally
        {
            em.close();
        }
    }

    public void subtractAmountFromBalance(String username, double amount)
    {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            User user = findUserByLogin(username);

            if(user != null) {
                double currentBalance = user.getBalance();
                if(currentBalance >= amount) {
                    user.setBalance(currentBalance - amount);
                    em.merge(user);
                }
                else {
                    throw new RuntimeException("Too few current funds to subtract desired amount.");
                }
            }

            em.getTransaction().commit();
        }

        catch(Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to subtract amount from user's balance.", ex);
        }

        finally
        {
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
            em.getTransaction().begin();

            User userToUpdate = findUserByLogin(username);

            if (userToUpdate != null) {
                userToUpdate.setPassword(newPassword);
                em.merge(userToUpdate);
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to reset password.", ex);
        } finally {
            em.close();
        }
    }
    public List<Object[]> findAllUsernamesAndWins() {
        EntityManager em = getEntityManager();
        List<Object[]> results = null;


        try {
            String query = "SELECT u.username, u.wins FROM User u";
            TypedQuery<Object[]> typedQuery = em.createQuery(query, Object[].class);
            results = typedQuery.getResultList();
        } catch (Exception ex) {
            throw new RuntimeException("Failed to fetch users and wins.", ex);
        }finally {
            em.close();
        }
        return results;
    }

    public void setSelectedImage(String username, String imagePath) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            User userToUpdate = findUserByLogin(username);

            if (userToUpdate != null) {
                userToUpdate.setSelectedImage(imagePath);
                em.merge(userToUpdate);
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to update selected image.", ex);
        } finally {
            em.close();
        }
    }



}