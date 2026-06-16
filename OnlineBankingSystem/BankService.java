package OnlineBankingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankService {

    private List<Account> accounts= new ArrayList<>();

    public void createAccount(Account acc){
        accounts.add(acc);
    }

    private Account findAccount(long accNo) {
        for (Account acc : accounts) {
            if (acc.getAccNo() == accNo)
                return acc;
        }
        throw new AccountNotFoundException("Account Not Found " +accNo);
    }

    private void updateDormantStatus(Account acc){
        if(acc.getLastTransactionDate().plusDays(15).isBefore(LocalDate.now())){
            acc.setStatus(AccountStatus.DORMANT);
        }
    }

    public void depositeMoney(long accNo, double amount)  {
        Account acc = findAccount(accNo);
        updateDormantStatus(acc);

        acc.setBalance(acc.getBalance()+amount);
        acc.setLastTransactionDate(LocalDate.now());
        acc.setStatus(AccountStatus.ACTIVE);
    }

    public boolean withdrawMoney(long accNo, double amount) {
        Account acc = findAccount(accNo);
        updateDormantStatus(acc);

        if (acc.getStatus() == AccountStatus.DORMANT)
            throw new DormantAccountException("Dormant account - only deposit allowed");

        if (acc.getBalance() - amount < acc.getMinBalance()) {
            System.out.println("Insufficient balance");
            return false;
        }

        acc.setBalance(acc.getBalance() - amount);
        acc.setLastTransactionDate(LocalDate.now());
        return true;
    }

    public boolean transferMoney(long fromAcc, long toAcc, double amount) {
        boolean withdrawn = withdrawMoney(fromAcc, amount);

        if (!withdrawn) {
            System.out.println("Transfer Failed");
            return false;
        }

        depositeMoney(toAcc, amount);
        System.out.println("Transfer Successful");
        return true;
    }

    public void viewAccount(long accNo)  {
        Account acc= findAccount(accNo);
        acc.display();
    }

    public void monthlyStatement(){
        for(Account acc: accounts){
            acc.setBalance(acc.getBalance()+acc.getBalance()*acc.getInterestRate()/100);
            acc.display();
            System.out.println("----");
        }
    }



}

