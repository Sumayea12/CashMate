package dev.repository;

import dev.domain.BillPayment;
import dev.domain.Donation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillPaymentRepository {private SessionFactory sessionFactory;


    public BillPaymentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(BillPayment billPayment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(billPayment);
    }

    public void edit(BillPayment billPayment) {
        Session session = sessionFactory.getCurrentSession();
        session.update(billPayment);
    }
    public List<BillPayment> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<BillPayment> billPaymentQuery = session.createQuery("from BillPayment", BillPayment.class);
        return billPaymentQuery.getResultList();
    }
}