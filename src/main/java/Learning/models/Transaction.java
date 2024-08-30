package Learning.models;

import java.util.Date;

public class Transaction {
    private Long senderId;
    private Long receiverId;
    private double amount;
    private Date date;

    public Transaction(Long senderId, Long receiverId, double amount, Date date) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.date = date;
    }
    @Override
    public String toString() {
        return "[Date : " + date.toString() + "Sender=" + senderId + "Receiver=" + receiverId + "Amount=" + amount + "]";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
