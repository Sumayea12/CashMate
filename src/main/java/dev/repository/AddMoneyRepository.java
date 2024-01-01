package dev.repository;

import dev.domain.AddMoney;
import dev.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Queue;

@Repository
public class AddMoneyRepository {private SessionFactory sessionFactory;


    public AddMoneyRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(AddMoney addMoney) {
        Session session = sessionFactory.getCurrentSession();
        session.save(addMoney);
    }

    public void edit(AddMoney addMoney) {
        Session session = sessionFactory.getCurrentSession();
        session.update(addMoney);
    }
    public List<AddMoney> getAAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<AddMoney> addMoneyQuery = session.createQuery("from AddMoney", AddMoney.class);
        return addMoneyQuery.getResultList();
    }

}

