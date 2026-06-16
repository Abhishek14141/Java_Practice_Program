package OnlineBankingSystem;

public class SavingAccount extends Account{

    public SavingAccount(long accNo,String name, double balance){
        super(accNo,name,balance);
    }

    @Override
    double getMinBalance() {
        return 1000;
    }

    @Override
    double getInterestRate() {
        return 6;
    }
}
