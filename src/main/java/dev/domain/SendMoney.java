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

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "send_money")
public class SendMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "send_id")
    private int sendId;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private UserAccount Useraccount;

    @Column(name = "amount")
    private int amount;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;

    // Getters and Setters
    public int getSendId() {
        return sendId;
    }

    public void setSendId(int sendId) {
        this.sendId = sendId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
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

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    // Constructors
    public SendMoney() {
    }

    public SendMoney(User sender, Transaction transaction, User receiver, UserAccount Useraccount, int amount, LocalDateTime sentAt) {
        this.sender = sender;
        this.transaction = transaction;
        this.receiver = receiver;
        this.Useraccount = Useraccount;
        this.amount = amount;
        this.sentAt = sentAt;
    }

    // toString method
    @Override
    public String toString() {
        return "SendMoney{" +
                "sendId=" + sendId +
                ", sender=" + sender +
                ", transaction=" + transaction +
                ", receiver=" + receiver +
                ", account=" + Useraccount +
                ", amount=" + amount +
                ", sentAt=" + sentAt +
                '}';
    }
}
