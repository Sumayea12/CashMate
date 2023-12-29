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
import java.time.LocalDate;

@Entity
@Table(name = "deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deposit_id")
    private int depositId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "deposit_amount")
    private int depositAmount;

    @Column(name = "deposit_date")
    private LocalDate depositDate;

    @Column(name = "deposit_duration")
    private int depositDuration;

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

    // Constructors
    public Deposit() {
    }

    public Deposit(User user, int depositAmount, LocalDate depositDate, int depositDuration) {
        this.user = user;
        this.depositAmount = depositAmount;
        this.depositDate = depositDate;
        this.depositDuration = depositDuration;
    }

    // toString method
    @Override
    public String toString() {
        return "Deposit{" +
                "depositId=" + depositId +
                ", user=" + user +
                ", depositAmount=" + depositAmount +
                ", depositDate=" + depositDate +
                ", depositDuration=" + depositDuration +
                '}';
    }
}
