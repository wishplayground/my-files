package lk.ijse.dep11;

public class Transaction {

    boolean credit;
    String dateAndTime;
    double openingBalance;
    double amount;
    double endingBalance;

    public Transaction(boolean credit, String dateAndTime, double openingBalance, double amount, double endingBalance) {
        this.credit = credit;
        this.dateAndTime = dateAndTime;
        this.openingBalance = openingBalance;
        this.amount = amount;
        this.endingBalance = endingBalance;
    }
}
