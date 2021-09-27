import java.sql.SQLException;

public class BankApp
{
	public static void main(String[] args) throws Exception 
	{
		AccountRepository1 repo= new jdbc_handler();
		
		AccountService accountService= new AccountService(repo);
		
		BankUI bankUI= new BankUI(accountService);
		
		BankUI.showUI();
	}
}
