

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;

public class AccountService {
	
	private AccountRepository1 accountRepository;

	
	
	public AccountService(AccountRepository1 accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	public void createAccounts(File accountFile) throws Exception {
		 BufferedReader reader= new BufferedReader(new FileReader(accountFile));
		 String line=reader.readLine();
		 while(line!=null) {
			 String []words= line.split(",");
			 Account account= new Account( Long.parseLong(words[0]), Integer.parseInt(words[2]), words[1], words[3]);
			 createAccount(account);
			 line=reader.readLine();
		 }
		 
		 reader.close();
		 accountFile.delete();
		
		
	}
	

	public boolean createAccount(Account account) throws Exception{
		
		boolean isCreated=accountRepository.createAccount(account);
		if(isCreated){
			System.out.println("Created Account Successfully");
		}
		return isCreated;		
	}
	
	public Account findAccount(Long accountNumber) throws Exception{
		
		return accountRepository.findAccount(accountNumber);
}
	
	public Set<Account> findAllAccounts() throws Exception{
		
		return accountRepository.findAllAccounts();
	}
	
	public Account[] findAllAccountsByName(){
		
		return null;
	}
	
	public boolean updateAccount(Account account){
		
		return false;		
	}
	
	
	public void deleteAccount(Long accountNumber){
		
	}
	
	public void transfer(Long fromAccountNumber,Long toAccountNumber){
		
	}

	

}
