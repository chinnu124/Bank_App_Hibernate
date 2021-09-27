import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;

public class jdbc_handler implements AccountRepository1 
{
	
	
	public jdbc_handler() throws SQLException
	{
		Connection connection=  DriverManager.getConnection("jdbc:mysql://localhost/store","root","root");
		
	}

	public boolean createAccount(Account account) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=  DriverManager.getConnection("jdbc:mysql://localhost/store","root","root");
		
		PreparedStatement statement=  
				connection.prepareStatement("insert into accounts(accountNumber,balance,accountHolderName,city) values(?,?,?,?)");
		statement.setInt(1,(int) account.getAccountNumber() );
		statement.setInt(2,account.getBalance());
		statement.setString(3, account.getAccountHolderName());
		statement.setString(4, account.getCity());
		statement.executeUpdate();
		connection.close();
		return false;
	}

	public Account findAccount(Long accountNumber) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "root");
		PreparedStatement statement = connection
				.prepareStatement("select * from accounts a where a.accountNumber=?");
		statement.setFloat(1, accountNumber);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			int accnum = rs.getInt("accountNumber");
			int bal = rs.getInt("balance");
			String Name = rs.getString("accountHolderName");
			String city = rs.getString("city");
			System.out.println(accnum + "," + bal + "," + Name+","+city);
		}
		rs.close();
		statement.close();
		connection.close();
		return null;
	}

	@Override
	public Set<Account>findAllAccounts() throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "root");
		PreparedStatement statement = connection
				.prepareStatement("select * from accounts");
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			int accnum = rs.getInt("accountNumber");
			int bal = rs.getInt("balance");
			String Name = rs.getString("accountHolderName");
			String city = rs.getString("city");
			System.out.println(accnum + "," + bal + "," + Name+","+city);
		}
		rs.close();
		statement.close();
		connection.close();
		return null;
	}
	
	public Properties getFileMap() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteAccount(Long accountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void transfer(Long fromAccountNumber, Long toAccountNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account[] findAllAccountsByName() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
