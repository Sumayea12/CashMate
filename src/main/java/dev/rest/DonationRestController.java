package dev.rest;

import dev.domain.Deposit;
import dev.domain.Donation;
import dev.domain.User;
import dev.domain.UserAccount;
import dev.service.DepositService;
import dev.service.DonationService;
import dev.service.UserAccountService;
import dev.service.UserService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.List;
import java.util.Queue;
@RestController
public class DonationRestController  {

    private DonationService donationService;
    private UserAccountService userAccountService;

    public DonationRestController(DonationService donationService, UserAccountService userAccountService) {
        this.donationService = donationService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/AllDonation")
    public List<Donation> getDonations() {
        return donationService.getAll();
    }

    @PostMapping("/AddDonation/{user_id}/{account_id}")
    public String createDonation(@RequestBody Donation donation, @PathVariable int user_id, @PathVariable int account_id) {
        // Retrieve User Account by ID using UserAccountService
        UserAccount userAccount = userAccountService.getById(account_id);

        // Set the user account for the donation
        donation.setUserAccount(userAccount);

        // Create the donation
        donationService.create(donation);

        return "Successful";
    }
}