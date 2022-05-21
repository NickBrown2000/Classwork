public class CheckingAccount extends Account
{

    public int checksWritten=0;

    public CheckingAccount(double initialBalance){
        super(initialBalance);
    }

    public void writeCheck(double amount){
        super.withdraw(amount);
        checksWritten++;
    }

    public int getChecksWritten(){
        return checksWritten;
    }

    public double getBalance(){
        return super.getBalance();
    }
}