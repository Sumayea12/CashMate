package dev.repository;

import dev.domain.Deposit;
import dev.domain.Donation;
import dev.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Queue;

@Repository
public class DonationRepository {private SessionFactory sessionFactory;


    public DonationRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Donation donation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(donation);
    }

    public void edit(Donation donation) {
        Session session = sessionFactory.getCurrentSession();
        session.update(donation);
    }
    public List<Donation> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Donation> donationQuery = session.createQuery("from Donation", Donation.class);
        return donationQuery.getResultList();
    }

}