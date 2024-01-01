package dev.domain;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "send_money")
public class SendMoney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "send_id")
    private int sendId;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @OneToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @OneToOne
    @JoinColumn(name = "sender_account_id")
    private UserAccount senderAccount;
    @OneToOne
    @JoinColumn(name = "receiver_account_id")
    private UserAccount receiverAccount;
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



    public User getReceiver() {
        return receiver=receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public UserAccount getSenderAccount() {
        return senderAccount;
    }
    public void setSenderAccount(UserAccount senderAccount) {
        this.senderAccount = senderAccount;
    }
    public UserAccount getReceiverAccount() {
        return receiverAccount;
    }
    public void setReceiverAccount(UserAccount receiverAccount) {
        this.receiverAccount = receiverAccount;
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

    public SendMoney(User sender, User receiver, UserAccount Useraccount, UserAccount senderAccount, UserAccount receiverAccount, int amount, LocalDateTime sentAt) {
        this.sender = sender;
        this.receiver = receiver;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.sentAt = sentAt;
    }

    // toString method
    @Override
    public String toString() {
        return "SendMoney{" +
                "sendId=" + sendId +
                ", sender=" + sender +

                ", receiver=" + receiver +
                ", senderAccount=" + senderAccount +
                ", receiverAccount=" + receiverAccount +
                ", amount=" + amount +
                ", sentAt=" + sentAt +
                '}';
    }
}
