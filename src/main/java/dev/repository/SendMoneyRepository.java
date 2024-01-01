package dev.repository;

import dev.domain.SendMoney;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SendMoneyRepository {

    private final SessionFactory sessionFactory;

    public SendMoneyRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(SendMoney sendMoney) {
        Session session = sessionFactory.getCurrentSession();
        session.save(sendMoney);
    }

    public void edit(SendMoney sendMoney) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sendMoney);
    }

    public List<SendMoney> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from SendMoney", SendMoney.class).getResultList();
    }
}
