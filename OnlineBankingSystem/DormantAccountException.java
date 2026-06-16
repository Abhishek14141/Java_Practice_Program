package OnlineBankingSystem;

public class DormantAccountException extends RuntimeException{
    public DormantAccountException(String msg){
        super(msg);
    }
}
