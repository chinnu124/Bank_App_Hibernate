

import java.util.Scanner;

public class IOUtil {
	
	static Scanner scanner= new Scanner(System.in);
	
	
	public static String readLineFromConsole(){
		
		
		String line= scanner.next()+scanner.nextLine();	
		//scanner.close();
		return line.trim();
		
	}
}
