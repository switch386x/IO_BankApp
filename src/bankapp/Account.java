package bankapp;
import java.io.Serializable;


public abstract class Account  implements Serializable{ //we dont want account objects per se
    private double balance = 0;
    private double interest = 0.02;
    private int accountNumber;
    private static int numberOfAccounts = 0;
    private double transactionFee;
    
    Account(){
        accountNumber = getNextAccountNumber();
    }
    
    public static int getNextAccountNumber(){
        return ++numberOfAccounts;
    }
    //metoda dziedziczona ->checking,savings
    public abstract String getAccountType();
    
    public double getBalance() {
        return balance;
    }

   
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest;
    }

    
    public void setInterest(double interest) {
        this.interest = interest;
    }

 
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount + transactionFee > balance){
          throw new InsufficientFundsException();
        }
        balance -= amount + transactionFee;
        checkInterest(0);
    }
    
    public void deposit(double amount) throws InvalidAmountException{
        if(amount <= 0){
            throw new InvalidAmountException();
        }
        checkInterest(amount);
        amount = amount + amount * interest;
        balance += amount;
    }
    
    public void checkInterest(double amount){
        if(balance + amount > 10000){
            interest = 0.05;
        } else {
            interest = 0.02;
        }
    }

    public double getTransactionFee() {
        return transactionFee;
    }
    
    public void setTransactionFee(double fee){
        this.transactionFee = fee;
    }

    void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

}