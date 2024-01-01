package dev.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deposit_id")
    private int depositId;

    @OneToOne
    @JoinColumn(name = "deposit_userId_Fk")
    private User user;

    @OneToOne
    @JoinColumn(name = "deposit_AccountId_Fk")
    private UserAccount userAccount;

    @Column(name = "deposit_amount")
    private int depositAmount;

    @Column(name = "deposit_date")
    private LocalDate depositDate;

    @Column(name = "deposit_duration")
    private int depositDuration;

    // Constructors
    public Deposit() {
    }

    public Deposit(User user, UserAccount userAccount, int depositAmount, LocalDate depositDate, int depositDuration) {
        this.user = user;
        this.userAccount = userAccount;
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
        this.depositDuration = depositDuration;
    }

    // Getters and Setters
    public int getDepositId() {
        return depositId;
    }

    public void setDepositId(int depositId) {
        this.depositId = depositId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public LocalDate getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(LocalDate depositDate) {
        this.depositDate = depositDate;
    }

    public int getDepositDuration() {
        return depositDuration;
    }

    public void setDepositDuration(int depositDuration) {
        this.depositDuration = depositDuration;
    }

    // toString method
    @Override
    public String toString() {
        return "Deposit{" +
                "depositId=" + depositId +
                ", user=" + user +
                ", userAccount=" + userAccount +
                ", depositAmount=" + depositAmount +
                ", depositDate=" + depositDate +
                ", depositDuration=" + depositDuration +
                '}';
    }
}
