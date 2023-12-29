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

@Entity
@Table(name = "bill_payments")
public class BillPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private int billId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private UserAccount useraccount;

    @Enumerated(EnumType.STRING)
    @Column(name = "bill_type")
    private BillType billType;

    @Column(name = "bill_amount")
    private int billAmount;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    // Getters and Setters
    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAccount getUserAccount() {
        return useraccount;
    }

    public void setAccount(UserAccount useraccount) {
        this.useraccount = useraccount;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public int getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    // Constructors
    public BillPayment() {
    }

    public BillPayment(User user, UserAccount useraccount, BillType billType, int billAmount, LocalDate paymentDate) {
        this.user = user;
        this.useraccount = useraccount;
        this.billType = billType;
        this.billAmount = billAmount;
        this.paymentDate = paymentDate;
    }

    // toString method
    @Override
    public String toString() {
        return "BillPayment{" +
                "billId=" + billId +
                ", user=" + user +
                ", account=" + useraccount +
                ", billType=" + billType +
                ", billAmount=" + billAmount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
