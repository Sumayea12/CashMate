
        package dev.service;
        import dev.domain.*;
        import dev.repository.*;
        import org.hibernate.Query;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.springframework.stereotype.Repository;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import java.sql.*;
        import java.util.List;
        import java.util.Queue;
@Service
@Transactional
public class BillPaymentService {
    private BillPaymentRepository billPaymentRepository;
    private UserAccountRepository userAccountRepository;
    public BillPaymentService(BillPaymentRepository billPaymentRepository,UserAccountRepository userAccountRepository)
    {this.billPaymentRepository = billPaymentRepository; this.userAccountRepository = userAccountRepository;}
    public void create(BillPayment billPayment){
        billPaymentRepository.create(billPayment);
        UserAccount userAccount = billPayment.getUserAccount();
        int billAmount = billPayment.getBillAmount();
        int currentBalance = userAccount.getAccountBalance();
        userAccount.setAccountBalance(currentBalance - billAmount);
        userAccountRepository.update(userAccount);
    }
    public List<BillPayment> getAll(){
        return billPaymentRepository.getAll();
    }
}
 