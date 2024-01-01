package dev.service;

import dev.domain.Deposit;
import dev.domain.Donation;
import dev.domain.User;
import dev.domain.UserAccount;
import dev.repository.DepositRepository;
import dev.repository.DonationRepository;
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
public class DonationService {

    private DonationRepository donationRepository;
    private UserAccountRepository userAccountRepository;
    public DonationService(DonationRepository donationRepository,UserAccountRepository userAccountRepository)
    {this.donationRepository = donationRepository; this.userAccountRepository = userAccountRepository;}

    public void create(Donation donation){

        donationRepository.create(donation);

        UserAccount userAccount = donation.getUserAccount();
        int donationAmount = donation.getDonationAmount();
        int currentBalance = userAccount.getAccountBalance();
        userAccount.setAccountBalance(currentBalance - donationAmount);

        userAccountRepository.update(userAccount);
    }

    public List<Donation> getAll(){
        return donationRepository.getAll();
    }
}
