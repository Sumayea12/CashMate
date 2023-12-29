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
import java.time.LocalDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "add_money")
public class AddMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private int addId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private UserAccount Useraccount;

    @Column(name = "amount")
    private int amount;

    @Column(name = "added_at")
    private LocalDateTime addedAt;

    // Getters and Setters
    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public UserAccount getAccount() {
        return Useraccount;
    }

    public void setAccount(UserAccount account) {
        this.Useraccount = account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    // Constructors
    public AddMoney() {
    }

    public AddMoney(User user, Transaction transaction, UserAccount Useraccount, int amount, LocalDateTime addedAt) {
        this.user = user;
        this.transaction = transaction;
        this.Useraccount = Useraccount;
        this.amount = amount;
        this.addedAt = addedAt;
    }

    // toString method
    @Override
    public String toString() {
        return "AddMoney{" +
                "addId=" + addId +
                ", user=" + user +
                ", transaction=" + transaction +
                ", account=" + Useraccount +
                ", amount=" + amount +
                ", addedAt=" + addedAt +
                '}';
    }
}
