class BankAccount{
	private int accountNumber;
	private String accountHolder;
	private double balance;

	BankAccount(int accountNumber,String accountHolder,double balance){
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	
	public int getaccountNumber(){
		return accountNumber;
	}
	public String getaccountHolder(){
		return accountHolder;
	}
	public double getbalance(){
		return balance;
	}
	
	public void setaccountNumber(int accountNumber){
		this.accountNumber=accountNumber;
	}
	public void setaccountHolder(String accountHolder){
		this.accountHolder=accountHolder;
	}
	public void setbalance(double balance){
		this.balance=balance;
	}
	public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }

}

class Bank{
    BankAccount[] accounts = new BankAccount[5];
    int accountCount = 0;

    public void addAccount(BankAccount account) {
        if (accountCount < accounts.length) {
            accounts[accountCount] = account;
            accountCount++;
        } else {
            System.out.println("Bank is full");
        }
    }

    public void WithdrawMoney(int accountNumber,double amount) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getaccountNumber() == accountNumber) {
                try{
                accounts[i].withdraw(amount);
                }catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void displayAccounts() {
        for (int i = 0; i < accountCount; i++) {
            System.out.println("Account Number: " + accounts[i].getaccountNumber());
            System.out.println("Account Holder Name: " + accounts[i].getaccountHolder());
            System.out.println("Balance: " + accounts[i].getbalance());
            System.out.println();
        }
    }
}
class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount account1 = new BankAccount(1001,"Alice", 5000);
        BankAccount account2 = new BankAccount(1002,"Bob", 3000);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.WithdrawMoney(1001, 6000);
        bank.WithdrawMoney(1002,1000);
        bank.displayAccounts();
    }

}