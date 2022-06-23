// Display Static MySQL.


import java.sql.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;  

class SQLiteJDBC
{
	public static void main(String args[]) throws IOException
	{
		try
		{
			Cruds constructor = new Cruds();		
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
}

class Cruds
{
	Cruds() 
	{
		Connection c = null;
		Statement stmt = null;
		try
		{
			Connection con=DriverManager.getConnection( "jdbc:mysql://165.22.14.77/dbSharvani","sharvani","pwdsharvani"); 
			Class.forName("com.mysql.jdbc.Driver");  
			// String connectionUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
			// Class.forName("org.sqlite.JDBC");
			// c = DriverManager.getConnection(connectionUrl, "sharvani", "pwdsharvani");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(isr);

			while (true)
			{
				System.out.println("Select one of the option below to proceed:\n1. Create Account.\n2. Display Customer details.\nEnter your option: ");
				int option = Integer.parseInt(reader.readLine());
				switch (option)
				{
					case 1:
						create(c, stmt);
						break;
					case 2:
						display(c, "SELECT * FROM bankDetails;");
						break;
					case 3:
						finalize(c, stmt);
						System.exit(0);	
				}
			}
		}
		catch (Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}

	}

	public static void create(Connection c, Statement stmt)
	{
		try
		{
			stmt = c.createStatement();
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(isr);

			System.out.println("Enter Account Number : ");
			int accountNumber = Integer.parseInt(reader.readLine());
			System.out.println("Enter Name : ");
			String name = reader.readLine();
			System.out.println("Enter Balance : ");
			int balance = Integer.parseInt(reader.readLine());

			String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
                  "VALUES (" + accountNumber + ", '" + name + "', " + balance + ", 1);";

			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}	
	}

	public static void display(Connection c, String query)
	{
		try
		{
			PreparedStatement ps = c.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int count = rsmd.getColumnCount();
			List<String> list = new ArrayList<String>();
			for (int counter = 1; counter <= count; counter++) 
			{
				String columnName = rsmd.getColumnName(counter);
				list.add(columnName);
			}
			while (rs.next())
			{
				for (int fcounter = 0; fcounter < count; fcounter++) 
				{
					System.out.println(list.get(fcounter) + ": " + rs.getString(list.get(fcounter))); 
				}
			}	
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	public void finalize(Connection c, Statement stmt)
	{
		try
		{
			stmt.close();
			c.close();
			System.out.println("1");
		}
		catch (Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}	
}
// String connectionUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";

// try (Connection conn = DriverManager.getConnection(connectionUrl, "username", "password");

















































// // Java program to demonstrate BufferedReader
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// class Test 
// {
// 	public static void main(String[] args) throws IOException
// 	{
//   //               // Creating InputStreamReader object
//   //               InputStreamReader isr = new InputStreamReader(System.in);

// 		// // Creating BufferedReader Object
// 		// BufferedReader reader = new BufferedReader(isr);

//   //               // Asking for input from user
//   //               // System.out.println("Enter String : ");

// 		// // Reading string data using readLine
// 		// String name = reader.readLine();
// 		// System.out.println(name);
// 		input("Hello World");
// 	}

// 	public static void input(String sentence)
// 	{
// 		// Creating InputStreamReader object
// 		InputStreamReader isr = new InputStreamReader(System.in);

// 		// Creating BufferedReader Object
// 		BufferedReader reader = new BufferedReader(isr);

//                 // Asking for input from user
//                 // System.out.println("Enter String : ");

// 		// Reading string data using readLine
// 		String name = reader.readLine(sentence);
// 		System.out.println(name);
// 	}
// }














// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// class printAndInput
// {
// 	public static void main(String args[])
// 	{
// 		try
// 		{

// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}

// 	public static String print(String stringToPrint)
// 	{
// 		try
// 		{
// 			System.out.println(sentence);
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}
// 	public static String input(String stringToInput)
// 	{
// 		try
// 		{
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);
// 			String name = reader.readLine();
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}
// }




























































// // Framework java.

// import java.sql.*;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;  
// import java.io.File;
// import java.io.FileReader;

// class SQLiteJDBC
// {
// 	public static void main(String args[]) throws IOException
// 	{
// 		try
// 		{
// 			Cruds constructor = new Cruds("menu.cfg");		
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}
// }

// class Cruds
// {
// 	Cruds(String fileName) 
// 	{
// 		Connection c = null;
// 		Statement stmt = null;
// 		try
// 		{
// 			Class.forName("org.sqlite.JDBC");
// 			c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
// 			c.setAutoCommit(false);
// 			stmt = c.createStatement();
			
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);
// 			String tableName = "bankDetails";
// 			String query = "SELECT * FROM " + tableName;
// 			List<String> fieldNames = getFieldNames(c, stmt, query);
// 			while (true)
// 			{
// 				readUsingBufferedReader(fileName);
// 				int option = Integer.parseInt(reader.readLine());
// 				switch (option)
// 				{
// 					case 1:
// 						create(c, stmt, fieldNames, tableName);
// 						break;
// 					case 2:
// 						display(c, stmt, fieldNames, query);
// 						break;
// 					case 3:
// 						finalize(c, stmt);
// 						System.exit(0);	
// 				}
// 			}
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}

// 	}

// 	public static void readUsingBufferedReader(String fileName) throws IOException
//     {
//     	try
//     	{
//     		File file = new File(fileName);
// 			FileReader fr = new FileReader(file);
// 			BufferedReader br = new BufferedReader(fr);
// 			String line;
// 			System.out.println("Read text file using BufferedReader");
// 			while ((line = br.readLine()) != null) 
// 			{
// 				System.out.println(line);
// 			}
// 		}
//     	catch (Exception e)
//     	{
//     		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
//     	}
//     }

//     public static List<String> getFieldNames(Connection c, Statement stmt, String query)
//     {
// 		List<String> fieldNames = new ArrayList<String>();
//     	try
//     	{
//     		stmt = c.createStatement();
//     		PreparedStatement ps = c.prepareStatement(query);
// 			ResultSet rs = ps.executeQuery();
// 			ResultSetMetaData rsmd=rs.getMetaData();
// 			int count = rsmd.getColumnCount();
// 			for (int counter = 1; counter < count; counter++) 
// 			{
// 				String columnName = rsmd.getColumnName(counter);
// 				fieldNames.add(columnName);
// 			}
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 		return fieldNames;
//     }
// 	public static void create(Connection c, Statement stmt, List fieldNames, String tableName)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);
// 			List<String> fieldValues = new ArrayList<String>();
// 			String delimiter = "', '";
// 			int count = fieldNames.size();
// 			for (int counter = 0; counter < count; counter++)
// 			{
// 				System.out.println("Enter " + fieldNames.get(counter) + ": ");
// 				fieldValues.add(reader.readLine());
// 			}
// 			System.out.println("list : " + fieldValues.toString());

// 			String result = String.join(delimiter, fieldValues);
// 			String sql = ("INSERT INTO " + tableName + " VALUES ('" + result + "', '1');");
// 			System.out.println(sql);
// 			stmt.executeUpdate(sql);
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}	
// 	}

// 	public static void display(Connection c, Statement stmt, List<String> fieldNames, String query)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			ResultSet rs = stmt.executeQuery(query);
// 			int count = fieldNames.size();
// 			while (rs.next())
// 			{
// 				for (int fcounter = 0; fcounter < count; fcounter++) 
// 				{
// 					String fieldName = fieldNames.get(fcounter);
// 					System.out.println(fieldName + ": " + rs.getString(fieldName)); 
// 				}
// 			}	
// 		} 
// 		catch (Exception e) 
// 		{
// 			System.out.println(e);
// 		}
// 	}

// 	public void finalize(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt.close();
// 			c.close();
// 			System.out.println("1");
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}	
// }

// javac -cp .;sqlite-jdbc-3.7.2.jar frameWork.java






























// // Display Static.

// import java.sql.*;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;  

// class SQLiteJDBC
// {
// 	public static void main(String args[]) throws IOException
// 	{
// 		try
// 		{
// 			Cruds constructor = new Cruds();		
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}
// }

// class Cruds
// {
// 	Cruds() 
// 	{
// 		Connection c = null;
// 		Statement stmt = null;
// 		try
// 		{
// 			Class.forName("org.sqlite.JDBC");
// 			c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
// 			c.setAutoCommit(false);
// 			stmt = c.createStatement();
			
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			while (true)
// 			{
// 				System.out.println("Select one of the option below to proceed:\n1. Create Account.\n2. Display Customer details.\nEnter your option: ");
// 				int option = Integer.parseInt(reader.readLine());
// 				switch (option)
// 				{
// 					case 1:
// 						create(c, stmt);
// 						break;
// 					case 2:
// 						display(c, "SELECT * FROM bankDetails;");
// 						break;
// 					case 3:
// 						finalize(c, stmt);
// 						System.exit(0);	
// 				}
// 			}
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}

// 	}

// 	public static void create(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			System.out.println("Enter Account Number : ");
// 			int accountNumber = Integer.parseInt(reader.readLine());
// 			System.out.println("Enter Name : ");
// 			String name = reader.readLine();
// 			System.out.println("Enter Balance : ");
// 			int balance = Integer.parseInt(reader.readLine());

// 			String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
//                   "VALUES (" + accountNumber + ", '" + name + "', " + balance + ", 1);";

// 			stmt.executeUpdate(sql);
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}	
// 	}

	// public static void display(Connection c, String query)
	// {
	// 	try
	// 	{
	// 		PreparedStatement ps = c.prepareStatement(query);
	// 		ResultSet rs = ps.executeQuery();
	// 		ResultSetMetaData rsmd=rs.getMetaData();
	// 		int count = rsmd.getColumnCount();
	// 		List<String> list = new ArrayList<String>();
	// 		for (int counter = 1; counter <= count; counter++) 
	// 		{
	// 			String columnName = rsmd.getColumnName(counter);
	// 			list.add(columnName);
	// 		}
	// 		while (rs.next())
	// 		{
	// 			for (int fcounter = 0; fcounter < count; fcounter++) 
	// 			{
	// 				System.out.println(list.get(fcounter) + ": " + rs.getString(list.get(fcounter))); 
	// 			}
	// 		}	
	// 	} 
	// 	catch (Exception e) 
	// 	{
	// 		System.out.println(e);
	// 	}
	// }

// 	public void finalize(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt.close();
// 			c.close();
// 			System.out.println("1");
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}	
// }

































// Constructor and distructor.


// import java.sql.*;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// class SQLiteJDBC
// {
// 	public static void main(String args[]) throws IOException
// 	{
// 		try
// 		{
// 			Cruds constructor = new Cruds();		
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}
// }

// class Cruds
// {
// 	Cruds() 
// 	{
// 		Connection c = null;
// 		Statement stmt = null;
// 		try
// 		{
// 			Class.forName("org.sqlite.JDBC");
// 			c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
// 			c.setAutoCommit(false);
// 			stmt = c.createStatement();
			
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			while (true)
// 			{
// 				System.out.println("Select one of the option below to proceed:\n1. Create Account.\n2. Display Customer details.\nEnter your option: ");
// 				int option = Integer.parseInt(reader.readLine());
// 				switch (option)
// 				{
// 					case 1:
// 						create(c, stmt);
// 						break;
// 					case 2:
// 						display(c, stmt);
// 						break;
// 					case 3:
// 						finalize(c, stmt);
// 						System.exit(0);	
// 				}
// 			}
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}

// 	}

// 	public static void create(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			System.out.println("Enter Account Number : ");
// 			int accountNumber = Integer.parseInt(reader.readLine());
// 			System.out.println("Enter Name : ");
// 			String name = reader.readLine();
// 			System.out.println("Enter Balance : ");
// 			int balance = Integer.parseInt(reader.readLine());

// 			String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
//                   "VALUES (" + accountNumber + ", '" + name + "', " + balance + ", 1);";

// 			stmt.executeUpdate(sql);
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}	
// 	}

// 	public static void display(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			ResultSet rs = stmt.executeQuery("SELECT * FROM bankDetails;");
// 			while (rs.next())
// 			{
// 				int accountNumber = rs.getInt("accountNumber");
// 				String name = rs.getString("name");
// 				int balance = rs.getInt("balance");
// 				int deleteStatus = rs.getInt("deleteStatus");

// 				System.out.println("Account Number: " + accountNumber);
// 				System.out.println("Name: " + name);
// 				System.out.println("Balance: " + balance);
// 			}	
// 		} 
// 		catch (Exception e) 
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 		System.out.println("Records created successfully");
// 	}

// 	public void finalize(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt.close();
// 			c.close();
// 			System.out.println("1");
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}	
// }

// D:\training\java>java -classpath ".;sqlite-jdbc-3.7.2.jar" SQLiteJDBC









































// Menu in Main.

// import java.sql.*;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// class SQLiteJDBC
// {
// 	public static void main(String args[]) throws IOException
// 	{
// 		Connection c = null;
// 		Statement stmt = null;
// 		try
// 		{
// 			Class.forName("org.sqlite.JDBC");
// 			c = DriverManager.getConnection("jdbc:sqlite:bankDetailsFile.db");
// 			c.setAutoCommit(false);
// 			stmt = c.createStatement();
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			while (true)
// 			{
// 				System.out.println("Select one of the option below to proceed:\n1. Create Account.\n2. Display Customer details.\nEnter your option: ");
// 				int option = Integer.parseInt(reader.readLine());
// 				switch (option)
// 				{
// 					case 1:
// 						CRUDS.create(c, stmt);
// 						break;
// 					case 2:
// 						CRUDS.display(c, stmt);
// 						break;
// 					case 3:
// 						// rs.close();
// 						stmt.close();
// 						c.close();
// 						System.exit(0);	
// 				}
// 			}
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 	}
// }

// class CRUDS
// {

// 	public static void create(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			InputStreamReader isr = new InputStreamReader(System.in);
// 			BufferedReader reader = new BufferedReader(isr);

// 			System.out.println("Enter Account Number : ");
// 			int accountNumber = Integer.parseInt(reader.readLine());
// 			System.out.println("Enter Name : ");
// 			String name = reader.readLine();
// 			System.out.println("Enter Balance : ");
// 			int balance = Integer.parseInt(reader.readLine());

// 			String sql = "INSERT INTO bankDetails (accountNumber,name,balance,deleteStatus) " +
//                   "VALUES (" + accountNumber + ", '" + name + "', " + balance + ", 1);";

// 			stmt.executeUpdate(sql);
// 		}
// 		catch (Exception e)
// 		{
// 			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}	
// 	}

// 	public static void display(Connection c, Statement stmt)
// 	{
// 		try
// 		{
// 			stmt = c.createStatement();
// 			ResultSet rs = stmt.executeQuery("SELECT * FROM bankDetails;");
// 			while (rs.next())
// 			{
// 				int accountNumber = rs.getInt("accountNumber");
// 				String name = rs.getString("name");
// 				int balance = rs.getInt("balance");
// 				int deleteStatus = rs.getInt("deleteStatus");

// 				System.out.println("Account Number: " + accountNumber);
// 				System.out.println("Name: " + name);
// 				System.out.println("Balance: " + balance);
// 			}	
// 		} 
// 		catch (Exception e) 
// 		{
// 			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
// 			System.exit(0);
// 		}
// 		System.out.println("Records created successfully");
// 	}	
// }

// D:\training\java>java -classpath ".;sqlite-jdbc-3.7.2.jar" SQLiteJDBC