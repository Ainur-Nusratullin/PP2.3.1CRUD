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

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUser() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void edit(User user) {
        User user1 = entityManager.find(User.class, user.getId());
        if (user1 != null) {
            user1.setName(user.getName());
            user1.setSurname(user.getSurname());
            user1.setSalary(user.getSalary());
            entityManager.merge(user1);
        }
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
