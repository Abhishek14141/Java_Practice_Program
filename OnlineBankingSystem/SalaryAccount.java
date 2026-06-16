package OnlineBankingSystem;

public class SalaryAccount extends Account  {
    public SalaryAccount(int accNo, String name, double balance){
        super(accNo,name,balance);
    }

    double getMinBalance(){
        return 0;
    }

    double getInterestRate(){
        return 5;
    }
}
