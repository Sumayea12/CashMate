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
@Entity
@Table(name = "management_accounts")
public class ManagementAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "management_account_id")
    private int managementAccountId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_balance")
    private int totalBalance;

    // Getters and Setters
    public int getManagementAccountId() {
        return managementAccountId;
    }

    public void setManagementAccountId(int managementAccountId) {
        this.managementAccountId = managementAccountId;
    }


    public int getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    // Constructors
    public ManagementAccount() {
    }

    public ManagementAccount(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    // toString method
    @Override
    public String toString() {
        return "ManagementAccount{" +
                "managementAccountId=" + managementAccountId +
                ", totalBalance=" + totalBalance +
                '}';
    }
}


