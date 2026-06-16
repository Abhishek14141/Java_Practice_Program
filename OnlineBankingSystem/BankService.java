package OnlineBankingSystem;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BankChoice {

    private List<Account> accounts= new ArrayList<>();

    public void createSavingAccount(int accNo, String accName, double balance){
        if(balance<1000)
            System.out.println("Minimum balance");


        accounts.add(new SavingAccount(accNo,accName,balance));
    }

    public void createCurrentAccount(int accNo, String accName, double balance) {
        accounts.add(new CurrentAccount(accNo, accName, balance));
    }

    private Account findAccount(int accNo)throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo)
                return acc;


        }
        throw new AccountNotFoundException("Account not found: " +accNo);
    }

    public void deposite(int accNo, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accNo);
        acc.deposite(amount);
    }

    public void withdraw(int accNo, double amount) throws AccountNotFoundException {
        Account acc= findAccount(accNo);
        acc.withdraw(amount);
    }

    public void transfer(int fromAcc,int toAcc, double amount) throws AccountNotFoundException {
        Account from = findAccount(fromAcc);
        Account to = findAccount(toAcc);

        from.withdraw(amount);
        to.deposite(amount);
    }

    public void viewAccount(int accNo) throws AccountNotFoundException {
        Account acc= findAccount(accNo);
        acc.display();
    }

    public void monthlyStatement(){
        for(Account acc: accounts){
            acc.calculateInterest();
            acc.display();
            System.out.println("----");
        }
    }



}

