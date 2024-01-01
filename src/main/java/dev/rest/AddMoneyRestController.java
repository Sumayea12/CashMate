package dev.rest;
import dev.domain.AddMoney;

import dev.domain.User;
import dev.domain.UserAccount;
import dev.service.AddMoneyService;

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
public class AddMoneyRestController {

    private AddMoneyService addMoneyService;
    private UserAccountService userAccountService; // Inject UserAccountService

    public AddMoneyRestController(AddMoneyService addMoneyService, UserAccountService userAccountService) {
        this.addMoneyService = addMoneyService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/AllAddMoney")
    public List<AddMoney> getAddMoney() {
        return addMoneyService.getAAll();
    }

    @PostMapping("/AddMoney/{user_id}/{account_id}")
    public String createAddMoney(@RequestBody AddMoney addMoney, @PathVariable int user_id, @PathVariable int account_id) {
        UserAccount userAccount = userAccountService.getById(account_id); // Retrieve User Account by ID using UserAccountService

        // Set the user account for the admoney
        addMoney.setAccount(userAccount);

        // Create the addMoney
        addMoneyService.create(addMoney);

        return "Successful";
    }
}

