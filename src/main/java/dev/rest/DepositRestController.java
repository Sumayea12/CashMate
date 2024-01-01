package dev.rest;
import dev.domain.Deposit;
import dev.domain.User;
import dev.domain.UserAccount;
import dev.service.DepositService;
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
public class DepositRestController {

    private DepositService depositService;
    private UserAccountService userAccountService; // Inject UserAccountService

    public DepositRestController(DepositService depositService, UserAccountService userAccountService) {
        this.depositService = depositService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/AllDeposit")
    public List<Deposit> getDeposits() {
        return depositService.getAll();
    }

    @PostMapping("/AddDeposit/{user_id}/{account_id}")
    public String createDeposit(@RequestBody Deposit deposit, @PathVariable int user_id, @PathVariable int account_id) {
        UserAccount userAccount = userAccountService.getById(account_id); // Retrieve User Account by ID using UserAccountService

        // Set the user account for the deposit
        deposit.setUserAccount(userAccount);

        // Create the deposit
        depositService.create(deposit);

        return "Successful";
    }
}

