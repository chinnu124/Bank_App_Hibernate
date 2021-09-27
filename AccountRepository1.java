import java.util.Properties;
import java.util.Set;

public interface AccountRepository1 {

	Properties getFileMap() throws Exception;

	boolean createAccount(Account account) throws Exception;

	Account findAccount(Long accountNumber) throws Exception;

	Set<Account> findAllAccounts() throws Exception;

	Account[] findAllAccountsByName();

	boolean updateAccount(Account account);

	void deleteAccount(Long accountNumber);

	void transfer(Long fromAccountNumber, Long toAccountNumber);

}