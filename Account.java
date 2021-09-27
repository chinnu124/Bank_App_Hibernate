

public class Account {
	
	 private long accountNumber;
	 private int balance;	 
	 private String accountHolderName;
	 private String city;
	 
	 public Account() {
	 }
	 
	 
	 
	public Account(long accountNumber, int balance, String accountHolderName,String city) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountHolderName = accountHolderName;
		this.city=city;
	}



	public void withDraw(int amount){
		if(balance>=amount){
			balance=balance-amount;
			System.out.println(" WithDrawn "+amount +" from account with number  "+accountNumber);
		}else{
			System.out.println("WithDraw failed .....balance is "+balance);
		}		
	}
	
	
	public void deposit(int amount){
		balance=balance+amount;
		System.out.println("Deposited "+amount+" in account with number "+accountNumber);
	}
	
	
	public String toString() {
		
		return accountNumber+","+accountHolderName+","+balance;
	}



	public long getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public String getAccountHolderName() {
		return accountHolderName;
	}



	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}



	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
		
}
