package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MainViewController {
    public Button btnPAssBook;
    public Spinner<Integer> spnAmount;
    public Button btnDeposit;
    public Button btnWithdraw;
    public Label lblBalance;

    double accountBalance;
    ArrayList<Transaction> transactionsList = new ArrayList<>();

    public void initialize(){
        btnWithdraw.setDisable(true);
        btnDeposit.setDisable(true);
        spnAmount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100000,0,100));

        spnAmount.valueProperty().addListener(e ->{
            btnDeposit.setDisable(spnAmount.getValue() <= 0 || spnAmount.getValue() > 10000);
            btnWithdraw.setDisable(btnDeposit.isDisable());
        });
    }
    public void btnDepositOnAction(ActionEvent event) {
        Transaction creditTransaction = new Transaction(true, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")), accountBalance, spnAmount.getValue(), accountBalance + spnAmount.getValue());

        accountBalance += spnAmount.getValue();
        lblBalance.setText(String.format("Balance: Rs. %,.2f",accountBalance));
        System.out.println(spnAmount.getValue() + " Deposited SuccessFully");

        spnAmount.getValueFactory().setValue(0);
        transactionsList.add(creditTransaction);
        //btnDeposit.setDisable(true);

    }

    public void btnWithdrawOnAction(ActionEvent event) {
        Transaction debitTransaction = new Transaction(false, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")), accountBalance, spnAmount.getValue(), accountBalance - spnAmount.getValue());

        double balanceAfterWithdraw = accountBalance - spnAmount.getValue();
        if(balanceAfterWithdraw < 0){
            System.out.println("Insufficient Acc Balance");
            return;
        }else {
            accountBalance = balanceAfterWithdraw;
            lblBalance.setText(String.format("Balance is: Rs.%,.2f",accountBalance));
            System.out.println(spnAmount.getValue() + " has been Withdrawn SucccessFully");
            spnAmount.getValueFactory().setValue(0);

        }
        transactionsList.add(debitTransaction);//stores object instance memory location
        //btnWithdraw.setDisable(true);
    }

    public void btnPAssBookOnAction(ActionEvent event) {
        final String LINE =  "+".concat("-".repeat(20)).concat("+")
                .concat("-".repeat(15)).concat("+")
                .concat("-".repeat(15).concat("+")
                        .concat("-".repeat(15)).concat("+"));
        System.out.println(LINE);
        System.out.printf("|%-20s|%-15s|%-15s|%-15s|\n","DATE TIME","TRANSACTION","AMOUNT","BALANCE");
        System.out.println(LINE);

        for (Transaction transaction: transactionsList) {
            System.out.printf("|%-20s|%-15s|%,15.2f|%15.2f|\n",transaction.dateAndTime,transaction.credit ? "Credit":"Debit",
                    transaction.amount,transaction.endingBalance);

        }
        System.out.println(LINE);

    }
}
