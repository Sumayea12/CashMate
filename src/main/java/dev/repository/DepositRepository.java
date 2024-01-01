package dev.repository;

import dev.domain.Deposit;
import dev.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Queue;

@Repository
public class DepositRepository {private SessionFactory sessionFactory;


    public DepositRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Deposit deposit) {
        Session session = sessionFactory.getCurrentSession();
        session.save(deposit);
    }

    public void edit(Deposit deposit) {
        Session session = sessionFactory.getCurrentSession();
        session.update(deposit);
    }
    public List<Deposit> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Deposit> depositQuery = session.createQuery("from Deposit", Deposit.class);
        return depositQuery.getResultList();
    }

}

