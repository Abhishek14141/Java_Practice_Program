package OnlineBankingSystem;

public class CurrentAccount extends Account{

    public CurrentAccount(long accNo,String name, double balance){
        super(accNo,name,balance);
    }

    @Override
    double getMinBalance() {
        return 0;
    }

    @Override
    double getInterestRate() {
        return 2;
    }
}
