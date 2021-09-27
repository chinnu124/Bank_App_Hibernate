
import java.util.Set;


public class BankUI {
	
	private static AccountService accountService;	
	
	public BankUI(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	
	public static void displayMenu(){
		System.out.println("1. Display All Accounts");
		System.out.println("2. Display Accounts By Account Number");
		System.out.println("3.Create a new Account");
		System.out.println("4.Exit");
		System.out.println("Enter your choice : ");
		
	}
	
	public static void showUI() throws Exception{
		while(true){
			displayMenu();
			int choice=0;
			try {
				 choice=Integer.parseInt(IOUtil.readLineFromConsole());
			} catch (Exception e) {
				
			}
			
			switch (choice) {
			case 1:			
				displayAllAccounts();
				break;
			case 2:			
				askAccountNumberAndDisplay();
				break;
			case 3:			
				askAccountDetailsAndSave();
				break;
			case 4:		
				System.out.println("Exiting........");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice..... Please select valid choice");
				break;
			}
		}
		
		
	}

	public static void askAccountDetailsAndSave() throws Exception{
		System.out.println("Enter Name :");
		String name=IOUtil.readLineFromConsole();
		System.out.println("Enter Account Number");
		long accountNumber=Long.parseLong(IOUtil.readLineFromConsole());
		System.out.println("Enter Balance :");
		int balance= Integer.parseInt(IOUtil.readLineFromConsole());	
		
		System.out.println("Enter city :");
		String city= IOUtil.readLineFromConsole();
		Account account= new Account(accountNumber, balance, name,city);		
		accountService.createAccount(account);
	}
	
	public static void askAccountNumberAndDisplay() throws Exception{
		System.out.println("Enter Account Number");
		long accountNumber=Long.parseLong(IOUtil.readLineFromConsole());
		Account account=accountService.findAccount(accountNumber);
		System.out.println(account);
	}
	
	public static void displayAllAccounts() throws Exception{
		
		Set<Account> accounts= accountService.findAllAccounts();
		
		for(Account account:accounts) {
			System.out.println(account);
		}
	}

}
