package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUser() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    //    @Override
//    public void delete(User user) {
//        entityManager.remove(user);
//    }
    @Override
    public void deleteById(int id) {
        User managedUser = entityManager.find(User.class, id); // находим managed entity по id
        if (managedUser != null) {
            entityManager.remove(managedUser); // удаляем managed entity
        }
    }

    @Override
    public void edit(User user) {
        User managedUser = entityManager.find(User.class, user.getId());
        if (managedUser != null) {
            managedUser.setName(user.getName());
            managedUser.setSurname(user.getSurname());
            managedUser.setSalary(user.getSalary());
            entityManager.merge(managedUser);
        }
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
