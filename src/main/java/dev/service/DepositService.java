package dev.service;

import dev.domain.Deposit;
import dev.domain.User;
import dev.domain.UserAccount;
import dev.repository.DepositRepository;
import dev.repository.UserAccountRepository;
import dev.repository.UserRepository;
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
public class DepositService {

    private DepositRepository depositRepository;
    private UserAccountRepository userAccountRepository;
    public DepositService(DepositRepository depositRepository,UserAccountRepository userAccountRepository)
    {this.depositRepository = depositRepository; this.userAccountRepository = userAccountRepository;}

        public void create(Deposit deposit){

            depositRepository.create(deposit);

            UserAccount userAccount = deposit.getUserAccount();
            int depositAmount = deposit.getDepositAmount();
            int currentBalance = userAccount.getAccountBalance();
            userAccount.setAccountBalance(currentBalance + depositAmount);

            userAccountRepository.update(userAccount);
        }

        public List<Deposit> getAll(){
            return depositRepository.getAll();
        }
    }

