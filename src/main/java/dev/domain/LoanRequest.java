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
@Table(name = "loan_requests")
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "management_account_id")
    private ManagementAccount managementAccount;

    @Column(name = "request_amount")
    private BigDecimal requestAmount;

    @Column(name = "request_date")
    private LocalDate requestDate;

    @Column(name = "duration_months")
    private int durationMonths;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RequestStatus status;

    // Getters and Setters
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ManagementAccount getManagementAccount() {
        return managementAccount;
    }

    public void setManagementAccount(ManagementAccount managementAccount) {
        this.managementAccount = managementAccount;
    }

    public BigDecimal getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(BigDecimal requestAmount) {
        this.requestAmount = requestAmount;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(int durationMonths) {
        this.durationMonths = durationMonths;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    // Constructors
    public LoanRequest() {
    }

    public LoanRequest(User user, ManagementAccount managementAccount, BigDecimal requestAmount, LocalDate requestDate, int durationMonths, RequestStatus status) {
        this.user = user;
        this.managementAccount = managementAccount;
        this.requestAmount = requestAmount;
        this.requestDate = requestDate;
        this.durationMonths = durationMonths;
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return "LoanRequest{" +
                "requestId=" + requestId +
                ", user=" + user +
                ", managementAccount=" + managementAccount +
                ", requestAmount=" + requestAmount +
                ", requestDate=" + requestDate +
                ", durationMonths=" + durationMonths +
                ", status=" + status +
                '}';
    }
}
