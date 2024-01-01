package dev.rest;
import dev.domain.*;
import dev.service.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.sql.*;
import java.util.List;
import java.util.Queue;
@RestController
public class BillPaymentRestController {
    private BillPaymentService billPaymentService;
    private UserAccountService userAccountService;
    public BillPaymentRestController(BillPaymentService billPaymentService, UserAccountService userAccountService) {
        this.billPaymentService = billPaymentService;
        this.userAccountService = userAccountService;
    }
    @GetMapping("/AllBillPayment")
    public List<BillPayment> getDonations() {
        return billPaymentService.getAll();
    }
    @PostMapping("/AddBillPayment/{user_id}/{account_id}")
    public String createBillPayment(@RequestBody BillPayment billPayment, @PathVariable int user_id, @PathVariable int account_id) {
        // Retrieve User Account by ID using UserAccountService
        UserAccount userAccount = userAccountService.getById(account_id);
        // Set the user account for the donation
        billPayment.setAccount(userAccount);
        // Create the donation
        billPaymentService.create(billPayment);
        return "Successful";
    }
}
