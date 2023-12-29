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
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donation_id")
    private Long donationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private UserAccount Useraccount;

    @Column(name = "donation_amount")
    private BigDecimal donationAmount;

    @Column(name = "donation_date")
    private LocalDate donationDate;

    @Column(name = "charity_name")
    private String charityName;

    // Getters and Setters
    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAccount getUserAccount() {
        return Useraccount;
    }

    public void setUserAccount(UserAccount Useraccount) {
        this.Useraccount = Useraccount;
    }

    public BigDecimal getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(BigDecimal donationAmount) {
        this.donationAmount = donationAmount;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public String getCharityName() {
        return charityName;
    }

    public void setCharityName(String charityName) {
        this.charityName = charityName;
    }

    // Constructors
    public Donation() {
    }

    public Donation(User user, UserAccount Useraccount, BigDecimal donationAmount, LocalDate donationDate, String charityName) {
        this.user = user;
        this.Useraccount = Useraccount;
        this.donationAmount = donationAmount;
        this.donationDate = donationDate;
        this.charityName = charityName;
    }

    // toString method
    @Override
    public String toString() {
        return "Donation{" +
                "donationId=" + donationId +
                ", user=" + user +
                ", account=" + Useraccount +
                ", donationAmount=" + donationAmount +
                ", donationDate=" + donationDate +
                ", charityName='" + charityName + '\'' +
                '}';
    }
}
