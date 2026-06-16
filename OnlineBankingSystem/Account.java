package OnlineBankingSystem;

import java.time.LocalDate;

public abstract class Account {

    protected long accNo;
    protected String name;
    protected double balance;
    protected AccountStatus status;
    protected LocalDate lastTransactionDate;


public Account(long accNo, String name, double balance){
    this.accNo=accNo;
    this.name=name;
    this.balance=balance;
    this.status=AccountStatus.ACTIVE;
    this.lastTransactionDate=LocalDate.now();
}

public long getAccNo(){
    return accNo;
}

public double getBalance(){
    return balance;
}

public AccountStatus getStatus(){
    return status;
}

public LocalDate getLastTransactionDate(){
    return  lastTransactionDate;
}

public void setBalance(double balance){
    this.balance=balance;
}

public void setStatus(AccountStatus status){
    this.status=status;
}

public void setLastTransactionDate(LocalDate date){
    this.lastTransactionDate=date;
}

public void display(){
    System.out.println("Account No: " +accNo);
    System.out.println("Account Name: " +name);
    System.out.println("Balance: " +balance);
    System.out.println("Status: " +status);
}

abstract double getMinBalance();
abstract double getInterestRate();

}


