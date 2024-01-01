package dev.repository;

import dev.domain.User;
import dev.domain.UserAccount;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAccountRepository {

    private SessionFactory sessionFactory;

    public UserAccountRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<UserAccount> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<UserAccount> userAccountQuery = session.createQuery("from UserAccount", UserAccount.class);
        return userAccountQuery.getResultList();
    }
    public void update(UserAccount userAccount) {
        Session session = sessionFactory.getCurrentSession();
        session.update(userAccount);
    }

    public UserAccount get(int accountId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserAccount.class, accountId);
    }
}
