package dev.domain;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    @OneToOne
    @JoinColumn(name = "user_id_accountsFk")
    private User user;

    @Column(name = "account_balance")
    private int accountBalance;

    // Getters and Setters
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    // Constructors
    public UserAccount() {
    }
    public UserAccount(User user, int accountBalance) {
        this.user = user;
        this.accountBalance = accountBalance;
    }

    // toString method
    @Override
    public String toString() {
        return "UserAccount{" +
                "accountId=" + accountId +
                ", user=" + user +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
